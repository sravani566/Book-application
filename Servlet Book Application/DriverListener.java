package com.bookstore.controller.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DriverListener implements ServletContextListener {

 
    public void contextInitialized(ServletContextEvent event)  { 
    	String driver=event.getServletContext().getInitParameter("driver");
    	try {
			Class.forName(driver);
			System.out.println("driver is succesfully loaded ");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent event)  { 
         
    }

	
}
