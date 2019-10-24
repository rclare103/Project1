package com.revature.service;

import com.revature.pojo.Message;

public interface MessageService {
	public void makeMessage(int rID);
	
	public void addMessage(String message, String role, int rID);
	
	public Message findMessages(int rID);
}
