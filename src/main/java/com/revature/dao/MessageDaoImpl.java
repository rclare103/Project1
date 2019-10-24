package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.Message;
import com.revature.util.ConnectionFactory;

public class MessageDaoImpl implements MessageDao {
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void createMessage(int rID) {
		String sql = "insert into Message (rID) values (?)";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addMessage(String message, String role, int rID) {
		String sql = "update Messages set ? = ? where rID = ?";
		PreparedStatement stmt;
		String mess = "";
		if (role.equals("supervisor")){
			mess = "dsMessage";
		} else if (role.equals("dephead")){
			mess = "dhMessage";
		} else if (role.contentEquals("benco")) {
			mess = "bcMessage";
		}
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mess);
			stmt.setString(2, message);
			stmt.setInt(3, rID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Message getMessages(int rID) {
		String sql = "select * from Messages where rID = ?";
		PreparedStatement stmt;
		Message mess = new Message();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mess.setDsMessage(rs.getString(1));
				mess.setDhMessage(rs.getString(2));
				mess.setBcMessage(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mess;

	}

}
