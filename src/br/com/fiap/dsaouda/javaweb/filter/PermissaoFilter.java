package br.com.fiap.dsaouda.javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.exception.SemPermissaoException;

abstract class PermissaoFilter implements Filter {

	private String uriPublico;
	private String perfil;

	public PermissaoFilter(String uriPublico, String perfil) {
		this.uriPublico = uriPublico;
		this.perfil = perfil;
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String requestURI = ((HttpServletRequest) request).getServletPath();
		
		if (requestURI.indexOf(uriPublico) == 0) {
			chain.doFilter(request, response);
			return ;
		}
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		String perfil = (String) session.getAttribute("perfil");
		
		if (perfil == null || !perfil.equals(this.perfil)) {
			throw new SemPermissaoException(); 
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
