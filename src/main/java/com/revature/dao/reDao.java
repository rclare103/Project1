package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import static com.revature.util.LoggerUtil.*;

public interface reDao {
	// reimbursement Dao

	public Reimbursement getReimbursement(int rID);

	public void createReimbursement(Reimbursement re);

	public List<Reimbursement> getAllReimbursements();

	public void updateReimbursement(Reimbursement re);

	public void deleteReimbursement(Reimbursement re);

	public List<Reimbursement> getReimbursementByUser(int userID);

	public List<Reimbursement> getReimbursementBySup(int userID);

	public List<Reimbursement> getReimbursementByDH(int userID);
	
	public void createMessage(int rID);
	
	public void addMessage(String message, String role, int rID);
	
	public void approveReimbursement(int rID, String role);
	
	public void addFinalGrade(int rID, String finalGrade);

}
