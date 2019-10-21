package com.revature.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementServiceImpl;

import static com.revature.util.LoggerUtil.*;


/**
 * Servlet implementation class TuitionFormServlet
 */
public class TuitionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ReimbursementServiceImpl reService = new ReimbursementServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TuitionFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		int userID = user.getUserID();
		debug("userID: " + userID);
		LocalDate submissionDate = java.time.LocalDate.now();
		debug("submissionDate:" + submissionDate);
		LocalTime submissionTime = java.time.LocalTime.now();
		debug("submissionTime: " + submissionTime);
		String eventType = request.getParameter("eventType");
		eventType = eventType.replace('_', ' ');
		debug("eventType: " + eventType);
		LocalDate eventDate = LocalDate.parse(request.getParameter("eventDate"));
		debug("eventDate: + eventDate");
		LocalTime eventTime = LocalTime.parse(request.getParameter("eventTime"));
		debug("eventTime: " + eventTime);
		String location = request.getParameter("location");
		debug("location:" + location);
		String description = request.getParameter("description");
		debug("description: " + description);
		Double cost = Double.parseDouble(request.getParameter("cost"));
		debug("cost: " + cost);
		String gradingFormat = request.getParameter("gradingFormat");
		debug("gradingFormat: " + gradingFormat);
		String justification = request.getParameter("justification");
		debug("justification: " + justification);
		String dhStatus;
		String dsStatus;
		String bcStatus;
		
		LocalDateTime eventDateTime = LocalDateTime.of(eventDate, eventTime);
		LocalDateTime submissionDateTime = LocalDateTime.of(submissionDate, submissionTime);
		
		Period period = Period.between(submissionDate, eventDate);
		if (period.getDays() <= 14) {
			dhStatus = dsStatus = bcStatus = "URGENT";
			info("DH: " + dhStatus + "\nDS: " + dsStatus + "\nBC: " + bcStatus);
			
		} else {
			dhStatus = dsStatus = bcStatus = "PENDING";
			info("DH: " + dhStatus + "\nDS: " + dsStatus + "\nBC: " + bcStatus);
		}
		
		Reimbursement re = new Reimbursement();
		re.setUserID(userID);
		re.setEventType(eventType);
		re.setEventDate(eventDate);
		re.setEventTime(eventTime);
		re.setLocation(location);
		re.setDescription(description);
		re.setCost(cost);
		re.setGradingFormat(gradingFormat);
		re.setJustification(justification);
		re.setSubmissionDate(submissionDate);
		re.setSubmissionTime(submissionTime);
		re.setBcStatus(bcStatus);
		re.setDsStatus(dsStatus);
		re.setDhStatus(dhStatus);
		
		reService.makeReimbursement(re);
	}

}
