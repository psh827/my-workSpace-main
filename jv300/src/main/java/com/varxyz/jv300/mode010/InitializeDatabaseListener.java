package com.varxyz.jv300.mode010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeDatabaseListener implements ServletContextListener {
	
	@Override	
    public void contextInitialized(ServletContextEvent event)  { 
		
		ServletContext context = event.getServletContext();
		InputStream is = null;
    	BufferedReader reader = null;
    	try {
    		is = context.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
    		reader = new BufferedReader(new InputStreamReader(is));
    		Map<String, String> dbInfo = new HashMap<String, String>();
    		String record = null;
    		while((record = reader.readLine()) != null) {
    			String[] fields = record.split("=");
    			dbInfo.put(fields[0], fields[1]);
    		}
    		
    		
    		
		} catch (IOException e) {
			e.printStackTrace();
		}  	

	}
	

	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("contextDestroyed() method called");
    }
	
}

