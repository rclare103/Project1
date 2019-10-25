package com.revature.driver;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementServiceImpl;
import com.revature.service.UserServiceImpl;


public class Driver {
	
	private static UserDaoImpl userDao = new UserDaoImpl();
	private static UserServiceImpl userService = new UserServiceImpl();
	private static ReimbursementService reService = new ReimbursementServiceImpl();
	
	public static void main(String[] args) {
		
		/*
		 * User user = new User(2, "test", "test", "test", "test", 1, 1, "test",
		 * 1000.0); userDao.createUser(user);
		 */
		
		
		
		String username = "supervisor";
		String password = "supervisor";
		User user = userService.loginUser(username, password);
		System.out.println(user.getFirstName());
		
		//List<Reimbursement> reList = reService.findReimbursementByUser(user.getUserID());
		List<Reimbursement> reList2 = reService.findReimbursementBySup(user.getUserID());
		System.out.println("Driver: " + reList2.get(0));
	}
}
