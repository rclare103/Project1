package com.revature.dao;

import java.util.List;

import com.revature.pojo.Message;

public interface MessageDao {
	
	public void createMessage(int rID);
	
	public void addMessage(String message, String role, int rID);
	
	public Message getMessages(int rID);
	
	public List<Message> getAllMessages();
}
