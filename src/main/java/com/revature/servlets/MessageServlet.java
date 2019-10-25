package com.revature.servlets;

import java.io.IOException;
import java.util.List;

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
		int rID = Integer.parseInt(request.getParameter("rIDshow"));
		String message = request.getParameter("message");
		Message mess = messageService.findMessages(rID);
		if (mess.getrID() == 0) {
			messageService.makeMessage(rID);
		}
		
		String role = user.getRole();
		
		messageService.addMessage(message, role, rID);
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
		//User user = (User) request.getSession().getAttribute("user");
		//int rID = Integer.parseInt(request.getParameter("rIDmess"));
		ObjectMapper om = new ObjectMapper();
		List<Message> messageList = messageService.findAllMessages();
		debug("Message list: " + messageList);
		response.setContentType("text/plain");
		response.getWriter().write(om.writeValueAsString(messageList));
	}

}
