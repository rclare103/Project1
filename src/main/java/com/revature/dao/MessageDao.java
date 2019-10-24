package com.revature.dao;

import com.revature.pojo.Message;

public interface MessageDao {
	
	public void createMessage(int rID);
	
	public void addMessage(String message, String role, int rID);
	
	public Message getMessages(int rID);
}
