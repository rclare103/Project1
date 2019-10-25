package com.revature.servlets;

import static com.revature.util.LoggerUtil.info;

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
import com.revature.service.ReimbursementServiceImpl;

import com.revature.util.LoggerUtil.*;

/**
 * Servlet implementation class DHHomeServlet
 */
public class DHHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementServiceImpl reService = new ReimbursementServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DHHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		info("Succesfully entered doGet DHHomeServlet userID = " + user.getUserID());
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
				
		List<Reimbursement> reList = reService.findReimbursementByDH(user.getUserID());
		info("List: " + reList.toString());
		response.setContentType("text/plain");
		response.getWriter().write(om.writeValueAsString(reList));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
