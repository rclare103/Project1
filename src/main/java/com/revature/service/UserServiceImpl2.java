package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

public class UserServiceImpl2 implements UserService {

	private static UserDao userDao = new UserDaoImpl();
	@Override
	public User loginUser(String username, String password) {
		System.out.println("Attempted login with creds: Username: "+ username +" Password: " + password);
				User user = userDao.getUser(username);
				
				System.out.println("User: " + user);
				
				if(((user.getUsername() != null) && (user.getPassword() != null)) && (user.getPassword().equals(password))) {
					System.out.println("Checking if Username: "+ user.getUsername() +" Password: " + user.getPassword());
					return user;
					
				}
					System.out.println("Checking if Username: "+ user.getUsername() +" Password: " + user.getPassword());
					return null;
	};

	

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
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}
