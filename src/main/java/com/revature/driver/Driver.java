package com.revature.driver;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;

public class Driver {
	
	private static UserDaoImpl userDao = new UserDaoImpl();
	private static UserServiceImpl userService = new UserServiceImpl();
	
	public static void main(String[] args) {
		
		/*
		 * User user = new User(2, "test", "test", "test", "test", 1, 1, "test",
		 * 1000.0); userDao.createUser(user);
		 */
		
		
		
		String username = "testUser";
		String password = "testPassword";
		User user = userService.loginUser(username, password);
		System.out.println(user.getFirstName());
		
		
	}
}
