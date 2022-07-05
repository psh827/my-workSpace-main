package com.varxyz.jv300.mode004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/mode004/file_upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2, 		// 2MB
		maxFileSize = 1024 * 1024 * 10,				// 10MB
		maxRequestSize = 1024 * 1024 * 50)			// 50MB
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "C:/temp";
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		File saveDir = new File(SAVE_DIR);
		if(!saveDir.exists()) { //이 directory가 존재하냐 안하냐
			saveDir.mkdir();
		}
		for(Part part : request.getParts()) {
			// C:\temp\eclipse.ini
			part.write(saveDir.getPath() + File.separator + extractFileName(part));
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3> Upload has been done successfully. </h3>");
		out.println("</body></html>");
		out.close();
		
		
		/*Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String header = en.nextElement();
			System.out.println(header + " = " + request.getHeader(header));
		}*/
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("contentDisp: " + contentDisp);
		for(String s : contentDisp.split(";")) {
			if(s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", "");
			}else {
				return s;
			}
			
		}
		return "";
	}

}
