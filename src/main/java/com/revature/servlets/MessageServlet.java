package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Message;
import com.revature.pojo.User;
import com.revature.service.MessageService;
import com.revature.service.MessageServiceImpl;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementServiceImpl;

import static com.revature.util.LoggerUtil.*;


/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReimbursementService reService = new ReimbursementServiceImpl();
	private static MessageService messageService = new MessageServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		debug("Succesfully loaded user in MessageServlet: " + user.getUsername());
		int rID = Integer.parseInt(request.getParameter("rID"));
		String message = request.getParameter("message");
		String role = user.getRole();
		
		messageService.addMessage(message, role, rID);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		int rID = Integer.parseInt(request.getParameter("rIDmess"));
		ObjectMapper om = new ObjectMapper();
		Message message = messageService.findMessages(rID);
		
		response.setContentType("text/plain");
		response.getWriter().write(om.writeValueAsString(message));
	}

}
