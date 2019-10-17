package com.revature.pojo;

import java.util.List;

public class User {
	//Two constructors, one with the acceptedReimbursement, one without
	
	private int userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int supervisor;
	private int departmentHead;
	private String role;
	private double availableReimbursement;
	private List<Reimbursement> acceptedReimbursement;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}
	public int getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(int departmentHead) {
		this.departmentHead = departmentHead;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getAvailableReimbursement() {
		return availableReimbursement;
	}
	public void setAvailableReimbursement(double availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}
	
	
	public List<Reimbursement> getAcceptedReimbursement() {
		return acceptedReimbursement;
	}
	public void setAcceptedReimbursement(List<Reimbursement> acceptedReimbursement) {
		this.acceptedReimbursement = acceptedReimbursement;
	}
	
	public User(int userID, String username, String password, String firstName, String lastName, int supervisor,
			int departmentHead, String role, double availableReimbursement) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.supervisor = supervisor;
		this.departmentHead = departmentHead;
		this.role = role;
		this.availableReimbursement = availableReimbursement;
	}
	
	
	
	public User(int userID, String username, String password, String firstName, String lastName, int supervisor,
			int departmentHead, String role, double availableReimbursement, List<Reimbursement> acceptedReimbursement) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.supervisor = supervisor;
		this.departmentHead = departmentHead;
		this.role = role;
		this.availableReimbursement = availableReimbursement;
		this.acceptedReimbursement = acceptedReimbursement;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptedReimbursement == null) ? 0 : acceptedReimbursement.hashCode());
		long temp;
		temp = Double.doubleToLongBits(availableReimbursement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + departmentHead;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + supervisor;
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (acceptedReimbursement == null) {
			if (other.acceptedReimbursement != null)
				return false;
		} else if (!acceptedReimbursement.equals(other.acceptedReimbursement))
			return false;
		if (Double.doubleToLongBits(availableReimbursement) != Double.doubleToLongBits(other.availableReimbursement))
			return false;
		if (departmentHead != other.departmentHead)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (supervisor != other.supervisor)
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", supervisor=" + supervisor + ", departmentHead="
				+ departmentHead + ", role=" + role + ", availableReimbursement=" + availableReimbursement
				+ ", acceptedReimbursement=" + acceptedReimbursement + "]";
	}
	
	
	
	
	
}
