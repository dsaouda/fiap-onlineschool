package br.com.fiap.dsaouda.javaweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.fiap.dsaouda.javaweb.factory.JpaUtil;

@WebListener
public class CreateDB implements ServletContextListener {

    public CreateDB() {
    }

    public void contextDestroyed(ServletContextEvent event)  { 
    }

    public void contextInitialized(ServletContextEvent event)  {
    	
    	JpaUtil.getEntityManager();
    	
    }
}
