package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.dao.reDao;
import com.revature.dao.reDaoImpl;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementServiceImpl;

import static com.revature.util.LoggerUtil.*;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reService = new ReimbursementServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession(false) == null) {
			response.sendRedirect("login.html");
		}
		
		User user = (User) request.getSession(false).getAttribute("user");
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		
		String name = request.getPathInfo();
		
		if (name != null && !"".equals(name.substring(1))) {
			
		} else {

			List<Reimbursement> reList = reService.findReimbursementByUser(user.getUserID());

			response.getWriter().write(om.writeValueAsString(reList));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
