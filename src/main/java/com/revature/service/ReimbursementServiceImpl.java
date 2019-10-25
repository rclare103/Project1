package com.revature.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.revature.dao.reDaoImpl;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class ReimbursementServiceImpl implements ReimbursementService {

	private static reDaoImpl reDao = new reDaoImpl();
	
	@Override
	public Reimbursement findReimbursementByID(int rID) {
		return reDao.getReimbursement(rID);
	}

	@Override
	public void makeReimbursement(Reimbursement re) {
		reDao.createReimbursement(re);
	}

	@Override
	public List<Reimbursement> findAllReimbursements() {
		return reDao.getAllReimbursements();
	}

	@Override
	public void deleteReimbursement(Reimbursement re) {
		reDao.deleteReimbursement(re);
	}

	@Override
	public void updateReimbursement(Reimbursement re) {
		reDao.updateReimbursement(re);
	}

	@Override
	public List<Reimbursement> findReimbursementByUser(int userID) {
		return reDao.getReimbursementByUser(userID);
	}

	@Override
	public List<Reimbursement> findReimbursementBySup(int userID) {
		return reDao.getReimbursementBySup(userID);
	}

	@Override
	public List<Reimbursement> findReimbursementByDH(int userID) {
		return reDao.getReimbursementByDH(userID);
	}

	@Override
	public void makeMessage(int rID) {
		reDao.createMessage(rID);
	}

	@Override
	public void addMessage(String message, String role, int rID) {
		reDao.addMessage(message, role, rID);
	}

	@Override
	public void approveReimbursement(int rID, String role, String status) {
		reDao.approveReimbursement(rID, role, status);
		
	}

	@Override
	public void addFinalGrade(int rID, String finalGrade) {
		reDao.addFinalGrade(rID, finalGrade);
		
	}

	
	

}
