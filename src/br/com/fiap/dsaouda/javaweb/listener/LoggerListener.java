package br.com.fiap.dsaouda.javaweb.listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.dsaouda.javaweb.dao.LoggerDao;
import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;
import br.com.fiap.dsaouda.javaweb.model.Logger;
import br.com.fiap.dsaouda.javaweb.model.Usuario;

/**
 * Application Lifecycle Listener implementation class LoggerListener
 *
 */
@WebListener
public final class LoggerListener implements ServletRequestListener {
	
    public void requestDestroyed(ServletRequestEvent event)  { 
    }

    public void requestInitialized(ServletRequestEvent event)  {
    	EntityManager em = JpaUtil.getEntityManager();
    	LoggerDao loggerDao = new LoggerDao(em);
    	
    	ServletRequest request = event.getServletRequest();
    	
    	HttpServletRequest http = (HttpServletRequest)request;
    	HttpSession session = http.getSession();
    	
    	String ip = request.getRemoteAddr();
    	String url = http.getRequestURI().toString();
    	String metodo = http.getMethod();
    	String info = http.getQueryString();
    	
    	Logger logger;
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
    	if (usuario != null) {
    		String perfil = (String) session.getAttribute("perfil");
    		
    		logger = new Logger(usuario, perfil, ip, url, metodo, info);
    		
    	} else {
    		logger = new Logger(ip, url, metodo, info);
    	}
    	
    	loggerDao.salvar(logger);
    	System.out.println(logger);
    }
	
}
