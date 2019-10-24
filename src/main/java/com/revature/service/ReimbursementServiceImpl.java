package com.revature.service;

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

}
