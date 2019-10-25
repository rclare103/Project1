package com.revature.service;

import java.util.List;

import com.revature.pojo.Message;

public interface MessageService {
	public void makeMessage(int rID);
	
	public void addMessage(String message, String role, int rID);
	
	public Message findMessages(int rID);
	
	public List<Message> findAllMessages();
}
