package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public class UserDaoImpl implements UserDao {
	/*
	 * Table Users: userID serial primary key, 
	 * username varchar not null, 
	 * password varchar not null,
	 * firstname varchar not null,
	 * lastname varchar not null,
	 * supervisor integer not null,
	 * departmentHead integer not null,
	 * role varchar not null,
	 * availableReimbursement numeric not null
	 */
	
	
	@Override
	public User getUser(String username) {
		return null;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	

}
