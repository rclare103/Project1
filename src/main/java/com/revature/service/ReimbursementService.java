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
}
