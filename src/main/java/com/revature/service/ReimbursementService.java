package com.revature.service;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public interface ReimbursementService {
	
	public Reimbursement findReimbursementByID(int rID);
	
	public void makeReimbursement(Reimbursement re);
	
	public List<Reimbursement> findAllReimbursements();
	
	public void deleteReimbursement(Reimbursement re);
	
	public void updateReimbursement(Reimbursement re);
	
	public List<Reimbursement> findReimbursementByUser(int userID);
	
	public List<Reimbursement> findReimbursementBySup(int userID);
	
	public List<Reimbursement> findReimbursementByDH(int userID);
	
	public void makeMessage(int rID);
	
	public void addMessage(String message, String role, int rID);
	
	public void approveReimbursement(int rID, String role);
	
	public void addFinalGrade(int rID, String finalGrade);
}
