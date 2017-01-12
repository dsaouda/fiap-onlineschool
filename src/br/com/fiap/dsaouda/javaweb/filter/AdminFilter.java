package br.com.fiap.dsaouda.javaweb.filter;

import javax.servlet.annotation.WebFilter;

@WebFilter("/admin/*")
public class AdminFilter extends PermissaoFilter {

	public AdminFilter() {
		super("/admin/login", "admin");
	}
}
