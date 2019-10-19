package com.revature.util;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public interface ReimbursementCalculator {
	
	public double getReimbursementCost(Reimbursement re);
	
	public double getAvailableReimbursement(User user);
	
}
