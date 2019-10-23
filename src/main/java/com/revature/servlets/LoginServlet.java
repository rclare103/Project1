package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;
import com.revature.util.ConnectionFactory;

import static com.revature.util.LoggerUtil.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDaoImpl userDao = new UserDaoImpl();
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("newvalue");
		
		ObjectMapper om = new ObjectMapper();

		String name = request.getPathInfo();

		if (name != null && !"".equals(name.substring(1))) {
			response.getWriter().write(om.writeValueAsString(userService.getUserByUsername(name.substring(1))));
		} else {

		List<User> userList = userService.getAllUsers();

			response.getWriter().write(om.writeValueAsString(userList));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		info(username + ".");
		info(password + ".");
		User user = userService.loginUser(username, password);
		User user2 = userDao.getUser(username);
		String dbUsername = user2.getUsername();
			
		System.out.println("username: " + dbUsername);
		
		info(user.getFirstName() + ".");
		if (user != null) {
			 
			 request.getSession().setAttribute("user", user);
			 if (user.getUsername().equals(dbUsername)) {
				 
				 response.sendRedirect("tuitionform.html");
			 } else {
				 //response.sendRedirect("emp"); 
			 }
			 
		} else {
			response.getWriter().write("Sorry, but you were not able to login correctly :(");
		}
	}

}