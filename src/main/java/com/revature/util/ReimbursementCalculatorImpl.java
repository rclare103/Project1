package com.revature.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.pojo.EventTypes;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class ReimbursementCalculatorImpl implements ReimbursementCalculator {

	@Override
	public double getReimbursementCost(Reimbursement re) {
		double cost = 0;
		Map<String, Double> reEvent = EventTypes.reEvent;

		String event = re.getEventType().toLowerCase();

		cost = reEvent.get(event) * re.getCost();
		cost = Math.floor(cost * 100);
		cost = cost / 100;
		return cost;
	}

	@Override
	public double getAvailableReimbursement(User user) {
		double avail = 1000;
		List<Reimbursement> reList = user.getReimbursements();
		if (reList != null) {

			for (Reimbursement re : reList) {
				String bc = re.getBcStatus().toLowerCase();
				String dh = re.getDhStatus().toLowerCase();
				String ds = re.getDsStatus().toLowerCase();
				if (bc.equals("approved") && dh.equals("approved") && ds.equals("approved")) {
					double cost = getReimbursementCost(re);
					avail -= cost;
				}
			}
		}

		return avail;
	}

}
