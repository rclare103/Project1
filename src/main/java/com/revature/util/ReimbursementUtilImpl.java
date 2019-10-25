package com.revature.util;

import java.time.LocalDate;
import java.time.Period;

import com.revature.pojo.Reimbursement;

public class ReimbursementUtilImpl implements ReimbursementUtil {

	@Override
	public Reimbursement checkDates(Reimbursement re) {
		LocalDate now = java.time.LocalDate.now();
		LocalDate submission = re.getSubmissionDate();
		Period period = Period.between(submission, now);
		if (re.getDhStatus() != "DENIED" && re.getDsStatus() != "DENIED" && re.getBcStatus() != "DENIED") {
			if (period.getMonths() >= 1 || period.getYears() >= 1) {
				re.setDhStatus("APPROVED");
				re.setDsStatus("APPROVED");
			}
			if (period.getDays() >= 3) {
				re.setDhStatus("APPROVED");
			}
			if (period.getDays() >= 7) {
				re.setDsStatus("APPROVED");
			}
		}
		return re;
	}

}
