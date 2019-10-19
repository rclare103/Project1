package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {
	
	private static Connection conn = ConnectionFactory.getConnection();
	/*
	 * Table Users: 
	 * 1. userID serial primary key, 
	 * 2. username varchar not null, 
	 * 3. password varchar not null,
	 * 4. firstname varchar not null,
	 * 5. lastname varchar not null,
	 * 6. supervisor integer not null,
	 * 7. departmentHead integer not null,
	 * 8. role varchar not null,
	 * 9. availableReimbursement numeric not null
	 */
	
	
	@Override
	public User getUser(String username) {
		String sql = "select * from Users where username = ?";
		User user = new User();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setUserID(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setSupervisor(rs.getInt(6));
				user.setDepartmentHead(rs.getInt(7));
				user.setRole(rs.getString(8));
				user.setAvailableReimbursement(rs.getDouble(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
