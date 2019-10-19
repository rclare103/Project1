package com.revature.service;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.pojo.User;

public interface UserService {
	
	public User loginUser(String username, String password);
	
	public User getUserByUsername(String username);
	
	public User getUserByID(int userID);
	
	public void makeUser(User user);
	
	public List<User> getAllUsers();
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
	
	
}
