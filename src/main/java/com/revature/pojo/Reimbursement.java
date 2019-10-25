package com.revature.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

import com.revature.dao.UserDaoImpl;

public class Reimbursement {
	private int rID;
	private int userID;
	private String eventType;
	private LocalDate eventDate;
	private LocalTime eventTime;
	private String location;
	private String description;
	private double cost;
	private String gradingFormat;
	private String justification;
	private LocalDate submissionDate;
	private LocalTime submissionTime;
	private String dsStatus;
	private String dhStatus;
	private String bcStatus;
	//private String message;
	private String finalGrade;
	private double EstimatedReimbursement;
	
	public int getrID() {
		return rID;
	}
	public void setrID(int rID) {
		this.rID = rID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public LocalTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public LocalDate getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
	
	public LocalTime getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(LocalTime submissionTime) {
		this.submissionTime = submissionTime;
	}
	public String getDsStatus() {
		return dsStatus;
	}
	public void setDsStatus(String dsStatus) {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.getUser(this.getUserID());
		if (user.getSupervisor() == user.getDepartmentHead()) {
			;
		}else {
			this.dsStatus = dsStatus;
		}
	}
	public String getDhStatus() {
		return dhStatus;
	}
	public void setDhStatus(String dhStatus) {
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.getUser(this.getUserID());
		if (user.getSupervisor() == user.getDepartmentHead()) {
			this.dsStatus = dhStatus;
		}
		this.dhStatus = dhStatus;
	}
	public String getBcStatus() {
		return bcStatus;
	}
	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}
	
	/*
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	*/
	
	public String getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	
	public double getEstimatedReimbursement() {
		return EstimatedReimbursement;
	}
	public void setEstimatedReimbursement(double estimatedReimbursement) {
		EstimatedReimbursement = estimatedReimbursement;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(EstimatedReimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bcStatus == null) ? 0 : bcStatus.hashCode());
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dhStatus == null) ? 0 : dhStatus.hashCode());
		result = prime * result + ((dsStatus == null) ? 0 : dsStatus.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventTime == null) ? 0 : eventTime.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((finalGrade == null) ? 0 : finalGrade.hashCode());
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + rID;
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		result = prime * result + ((submissionTime == null) ? 0 : submissionTime.hashCode());
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(EstimatedReimbursement) != Double.doubleToLongBits(other.EstimatedReimbursement))
			return false;
		if (bcStatus == null) {
			if (other.bcStatus != null)
				return false;
		} else if (!bcStatus.equals(other.bcStatus))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dhStatus == null) {
			if (other.dhStatus != null)
				return false;
		} else if (!dhStatus.equals(other.dhStatus))
			return false;
		if (dsStatus == null) {
			if (other.dsStatus != null)
				return false;
		} else if (!dsStatus.equals(other.dsStatus))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventTime == null) {
			if (other.eventTime != null)
				return false;
		} else if (!eventTime.equals(other.eventTime))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (finalGrade == null) {
			if (other.finalGrade != null)
				return false;
		} else if (!finalGrade.equals(other.finalGrade))
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (rID != other.rID)
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		if (submissionTime == null) {
			if (other.submissionTime != null)
				return false;
		} else if (!submissionTime.equals(other.submissionTime))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", userID=" + userID + ", eventType=" + eventType + ", eventDate="
				+ eventDate + ", eventTime=" + eventTime + ", location=" + location + ", description=" + description
				+ ", cost=" + cost + ", gradingFormat=" + gradingFormat + ", justification=" + justification
				+ ", submissionDate=" + submissionDate + ", submissionTime=" + submissionTime + ", dsStatus=" + dsStatus
				+ ", dhStatus=" + dhStatus + ", bcStatus=" + bcStatus + ", finalGrade=" + finalGrade
				+ ", EstimatedReimbursement=" + EstimatedReimbursement + "]";
	}
	public Reimbursement(int rID, int userID, String eventType, LocalDate eventDate, LocalTime eventTime,
			String location, String description, double cost, String gradingFormat, String justification,
			LocalDate submissionDate, LocalTime submissionTime, String dsStatus, String dhStatus, String bcStatus,
			String finalGrade, double estimatedReimbursement) {
		super();
		this.rID = rID;
		this.userID = userID;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.justification = justification;
		this.submissionDate = submissionDate;
		this.submissionTime = submissionTime;
		this.dsStatus = dsStatus;
		this.dhStatus = dhStatus;
		this.bcStatus = bcStatus;
		this.finalGrade = finalGrade;
		EstimatedReimbursement = estimatedReimbursement;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}


