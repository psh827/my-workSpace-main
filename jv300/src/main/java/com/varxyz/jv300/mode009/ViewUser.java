package com.varxyz.jv300.mode009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewUser
 */
@WebServlet("/mode009/view_user.do")
public class ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
    private User user;
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		userService = new UserService(new UserDao());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		String error = "";
		if(userId == null || userId.length() == 0) {
			error = "id는 필수입력 정보입니다.";
		} else if (!userId.equals(user.getUserId())) {
			error = "id가 다르거나 없습니다.";
		}
		
		RequestDispatcher dispatcher = null;
		
		if(error.length() > 0) {
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("/error/error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		userService.getUserByUserId(userId);
		
		dispatcher = request.getRequestDispatcher("/mode009/view_user.do");
		dispatcher.forward(request, response);
		
		
		
		
	}

}
