package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Message;
import com.revature.util.ConnectionFactory;

public class MessageDaoImpl implements MessageDao {
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void createMessage(int rID) {
		String sql = "insert into Messages (rID) values (?)";
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
		String sql = "";
		
		if (role.equals("supervisor")){
			sql = "update Messages set dsMessage = ? where rID = ?";
		} else if (role.equals("dephead")){
			sql = "update Messages set dhMessage = ? where rID = ?";
		} else if (role.contentEquals("benco")) {
			sql = "update Messages set bcMessage = ? where rID = ?";
		}
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, message);
			stmt.setInt(2, rID);
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
				mess.setrID(rs.getInt(1));
				mess.setDsMessage(rs.getString(2));
				mess.setDhMessage(rs.getString(3));
				mess.setBcMessage(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mess;

	}

	@Override
	public List<Message> getAllMessages() {
		String sql = "select * from Messages";
		List<Message> messageList = new ArrayList<Message>();
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Message mess = new Message();
				mess.setrID(rs.getInt(1));
				mess.setDsMessage(rs.getString(2));
				mess.setDhMessage(rs.getString(3));
				mess.setBcMessage(rs.getString(4));
				messageList.add(mess);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return messageList;
	}

}
