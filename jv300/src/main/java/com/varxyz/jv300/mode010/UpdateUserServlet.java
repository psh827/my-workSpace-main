package com.varxyz.jv300.mode010;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/mode010/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private UserService userService;
	
	public void init() {
		userService = new UserService(new UserDao());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwd = request.getParameter("passwd");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		if(!userService.isValidUser(passwd)) {
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
			return;
		}
		
		User user = userService.findUserByUserPasswd(passwd);
		
		user.setEmail(email1 + "@" + email2);
		user.setAddr(addr1 + " " + addr2);
		
		userService.updateUser(user);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		response.sendRedirect("mypage");
		
	}

}
