package com.revature.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.dao.UserDaoImpl;
import com.revature.dao.reDaoImpl;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import static com.revature.util.LoggerUtil.*;

public class UserServiceImpl implements UserService {
	private static UserDaoImpl userDao = new UserDaoImpl();
	private static reDaoImpl reDao = new reDaoImpl();

	@Override
	public User loginUser(String username, String password) {
		debug("Attempted login with creds: Username: " + username + " Password: " + password);

		User user = userDao.getUser(username);

		System.out.println("User: " + user);

		if (((user.getUsername() != null) && (user.getPassword() != null)) && (user.getPassword().equals(password))) {
			debug("Checking if Username: " + user.getUsername() + " Password: " + user.getPassword());
			return user;

		}
		debug("Checking if Username: " + user.getUsername() + " Password: " + user.getPassword());
		return null;
	}



	@Override
	public User getUserByUsername(String username) {
		return userDao.getUser(username);
	}

	@Override
	public User getUserByID(int userID) {
		return userDao.getUser(userID);
	}

	@Override
	public void makeUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

}
