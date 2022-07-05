package com.varxyz.jv300.mode009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCourseContentServlet
 */
@WebServlet("/mode009/list_course_content.do")
public class ListCourseContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String[]> contentList;
	private static List<String> goList;
	
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		contentList = (List<String[]>)context.getAttribute("contentList");
		goList = tapToSpace(contentList);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("goList", goList);
		request.getRequestDispatcher("list_course_content.jsp").forward(request, response);
	}
	
	public List<String> goList2(List<String[]> contentList){
		for(String[] s : contentList) {
			for(String s1 : s) {
				goList.add(s1);				
			}
		}
		return goList;
	}
	
	
	private List<String> tapToSpace(List<String[]> contentList){
		List<String> lineList = new ArrayList<>();
		if(contentList != null) {
			for(String[] content : contentList) {
				if(isEmpty(content)) {
					continue;
				}
				for(int i = 0; i < content.length; i++) {
					if(content[i].length() == 0) {
						content[i] = "<span class=\"blank\">";
						content[content.length - 1] = content[content.length - 1] + "</span>";
					}
				}
			}
		}else {
			goList.add("--no Data--");
		}
		String line = "";
		for(String[] s : contentList) {
			for(String s1 : s) {
				line += s1;
			}
			lineList.add(line);
			line = "";
		}
		
		return lineList;
	}
	
	public Boolean isEmpty(String[] e) {
		if(e.length == 0) {
			return true;
		}
		return false;
	}
	
}
