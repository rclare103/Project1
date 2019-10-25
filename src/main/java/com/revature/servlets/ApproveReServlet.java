package com.revature.servlets;

import static com.revature.util.LoggerUtil.debug;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementServiceImpl;

/**
 * Servlet implementation class ApproveReServlet
 */
public class ApproveReServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reService = new ReimbursementServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveReServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		debug("Succesfully loaded user in ApproveReServlet: " + user.getUsername());
		String role = user.getRole();
		int rID = Integer.parseInt(request.getParameter("rID"));
		
		reService.approveReimbursement(rID, role);
		if (user.getRole().equals("supervisor")){ 
			response.sendRedirect("supervisorhome.html");
		} else if (user.getRole().equals("dephead")){
			response.sendRedirect("depheadhome.html");
		} else if (user.getRole().equals("benco")) {
			response.sendRedirect("bencohome.html");
		} else {
			response.sendRedirect("login.html");
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
