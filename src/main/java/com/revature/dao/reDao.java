package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public interface reDao {
	//reimbursement Dao
	
	public Reimbursement getReimbursement(int rID);
	
	public void createReimbursement(Reimbursement re);
	
	public List<Reimbursement> getAllReimbursements();
	
	public void updateReimbursement(Reimbursement re);
	
	public void deleteReimbursement(Reimbursement re);
	
	public List<Reimbursement> getReimbursementByUser(int userID);
	
	
}
