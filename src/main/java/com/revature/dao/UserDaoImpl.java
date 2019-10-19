package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		return user;
	}
	
	@Override
	public User getUser(int userID) {
		String sql = "select * from Users where userID = ?";
		User user = new User();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
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
		return user;
	}

	@Override
	public void createUser(User user) {
		String sql = "insert into Users (username, password, firstname, lastname, "
				+ "supervisor, departmentHead, role, availableReimbursement) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(5, user.getSupervisor());
			stmt.setInt(6, user.getDepartmentHead());
			stmt.setString(7, user.getRole());
			stmt.setDouble(8, user.getAvailableReimbursement());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select * from Users";
		List<User> userList = new ArrayList<User>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setSupervisor(rs.getInt(6));
				user.setDepartmentHead(rs.getInt(7));
				user.setRole(rs.getString(8));
				user.setAvailableReimbursement(rs.getDouble(9));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void updateUser(User user) {
		String sql = "update Users set username = ?, "
				+ "password = ?, firstname = ?, lastname = ?, supervisor = ?, "
				+ "departmentHead = ?, rolse = ?, availableReimbursement = ? "
				+ "where userID = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setInt(5, user.getSupervisor());
			stmt.setInt(6, user.getDepartmentHead());
			stmt.setString(7, user.getRole());
			stmt.setDouble(8, user.getAvailableReimbursement());
			stmt.setInt(9, user.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(User user) {
		String sql = "delete from Reimbursements where userID = ?";
		String sql2 = "delete from Users where userID = ?";
		
		PreparedStatement stmt1;
		PreparedStatement stmt2;
		
		try {
			stmt1 = conn.prepareStatement(sql);
			stmt1.setInt(1, user.getUserID());
			stmt1.executeQuery();
			
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setInt(1,  user.getUserID());
			stmt2.executeQuery();
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
