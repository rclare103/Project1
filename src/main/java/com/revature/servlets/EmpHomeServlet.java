package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.MessageServiceImpl;
import com.revature.service.ReimbursementServiceImpl;
import static com.revature.util.LoggerUtil.*;

/**
 * Servlet implementation class EmpHome
 */
public class EmpHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementServiceImpl reService = new ReimbursementServiceImpl();
	private static MessageServiceImpl messageService = new MessageServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false) == null) {
			response.sendRedirect("login.html");
		}
		User user = (User) request.getSession().getAttribute("user");
		debug("Succesfully entered doGet userID = " + user.getUserID());
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
				
		List<Reimbursement> reList = reService.findReimbursementByUser(user.getUserID());
		debug("List: " + reList.toString());
		response.setContentType("text/plain");
		response.getWriter().write(om.writeValueAsString(reList));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rID = Integer.parseInt(request.getParameter("rID"));
		String finalGrade = request.getParameter("finalGrade");
		
		
		
	}

}
