package com.revature.driver;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;
import com.revature.service.UserServiceImpl;

public class Driver {
	
	private static UserDaoImpl userDao = new UserDaoImpl();
	private static UserServiceImpl userService = new UserServiceImpl();
	
	public static void main(String[] args) {
		
		User user = new User(2, "test", "test", "test", "test", 1, 1, "test", 1000.0);
		userDao.createUser(user);
		
		user = userDao.getUser("test");
		System.out.println(user.getFirstName());
		
		User user2 = new User();
		user2 = userService.loginUser("testUser", "testPassword");
		System.out.println(user2.getFirstName());
		
	}
}
