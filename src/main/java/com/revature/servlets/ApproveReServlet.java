package com.revature.servlets;

import static com.revature.util.LoggerUtil.debug;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.Message;
import com.revature.pojo.User;
import com.revature.service.MessageService;
import com.revature.service.MessageServiceImpl;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementServiceImpl;

/**
 * Servlet implementation class ApproveReServlet
 */
public class ApproveReServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reService = new ReimbursementServiceImpl();
	private static MessageService messageService = new MessageServiceImpl();
       
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
		if (request.getSession(false) == null) {
			response.sendRedirect("login.html");
		}
		User user = (User) request.getSession().getAttribute("user");
		debug("Succesfully loaded user in ApproveReServlet: " + user.getUsername());
		String role = user.getRole();
		int rID = Integer.parseInt(request.getParameter("rID"));
		String status = request.getParameter("approveDeny");
		debug("approvere status: " + status);
		String message = request.getParameter("approvedenymess");
		Message mess = messageService.findMessages(rID);
		if (mess.getrID() == 0) {
			messageService.makeMessage(rID);
		}
		
		messageService.addMessage(message, role, rID);
		reService.approveReimbursement(rID, role, status);
		if (user.getRole().equals("supervisor")){ 
			response.sendRedirect("supervisorhome.html");
		} else if (user.getRole().equals("dephead")){
			response.sendRedirect("dhhome.html");
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
