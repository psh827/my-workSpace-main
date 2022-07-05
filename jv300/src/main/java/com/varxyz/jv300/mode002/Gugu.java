package com.varxyz.jv300.mode002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugu extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String pageTitle = "Hello World";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title><style>p{width:700px;display:flex;justify-content:space-between;}</style></head>");
		out.println("<body>");
		out.println("<h3>구구단</h3>");
		for(int i = 1; i <= 9; i++) {
			out.println("<p>");
			for(int j = 2; j <= 9; j++) {
				out.println("<span>");
				out.println(j + " X " + i + " = " + (j * i) + "\t");
				out.println("</span>");
			}
			out.println("</p>");
		}
		out.println("</body></html>");
		out.close();
	}
}
