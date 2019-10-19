package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;
import static com.revature.util.LoggerUtil.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static UserServiceImpl userService = new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + ".");
		System.out.println(password + ".");
		User user2 = userService.loginUser("testUser", "testPassword");
		System.out.println(user2.getFirstName());
		if (user2 != null) {
			 System.out.println("in if statement");
			 //request.getSession().setAttribute("user", user);
			 if (user2.getUsername().equals("testUser")) {
				 response.sendRedirect("home");
			 } else {
				 //response.sendRedirect("emp"); 
			 }
			 
		} else {
			response.getWriter().write("Sorry, but you were not able to login correctly :(");
		}
	}

}
