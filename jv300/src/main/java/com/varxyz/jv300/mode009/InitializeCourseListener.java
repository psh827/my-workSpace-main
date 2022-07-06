package com.varxyz.jv300.mode009;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeCourseListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent event)  { 
//		System.out.println("contextInitialized() method called");
//		
//		ServletContext context = event.getServletContext();
//    	InputStream is = null;
//    	BufferedReader reader = null;
//    	try {
//			is = context.getResourceAsStream("/WEB-INF/classes/course_content.txt");
//			reader = new BufferedReader(new InputStreamReader(is)); //데코레이터 패턴
//			String record = null;
//			List<String[]> contentList = new ArrayList<>();
//			while((record = reader.readLine()) != null) {
//				record = escapeHtml(record);
//				String[] fields = record.split("\t");
//				contentList.add(fields);
//			}
//			context.setAttribute("contentList", contentList);
//			System.out.println("The course contents has been loaded");
//    	} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }
//	
//	private String escapeHtml(String record) {
//		if(record.length() == 0) {
//			return record;
//		}
//		return record.replace("<", "&lt;").replace(">", "&gt;");
	}

	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
//    	System.out.println("contextDestroyed() method called");
    }
	
}

