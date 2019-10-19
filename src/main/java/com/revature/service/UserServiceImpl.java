package com.revature.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.dao.UserDaoImpl;
import com.revature.dao.reDaoImpl;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class UserServiceImpl implements UserService {
	private static UserDaoImpl userDao = new UserDaoImpl();
	private static reDaoImpl reDao = new reDaoImpl();
	
	
	@Override
	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

}
