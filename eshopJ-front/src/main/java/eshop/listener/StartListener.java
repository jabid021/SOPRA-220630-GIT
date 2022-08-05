package eshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import eshop.context.Singleton;


public class StartListener implements ServletContextListener {

	
	
	public void contextInitialized(ServletContextEvent sce)  { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Tomcat Start");
			Singleton.getInstance();
			
			
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
		}
    }
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
        	Singleton.getInstance().getEmf().close();
        	System.out.println("Tomcat Close");
    }

   
}
