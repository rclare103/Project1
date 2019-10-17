package com.revature.dao;

import java.util.List;

import com.revature.pojo.Reimbursement;

public interface reDao {
	//reimbursement Dao
	
	public Reimbursement getReimbursement(int rID);
	
	public void createReimbursement();
	
	public List<Reimbursement> getAllReimbursements();
	
	public List<Reimbursement> getReimbursementByUser();
	
	public void updateReimbursement();
	
	public void deleteReimbursement();
	
}
