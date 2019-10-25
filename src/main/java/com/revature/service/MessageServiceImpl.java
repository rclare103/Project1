package com.revature.service;

import java.util.List;

import com.revature.dao.MessageDaoImpl;
import com.revature.pojo.Message;

public class MessageServiceImpl implements MessageService {
	
	private static MessageDaoImpl messageDao = new MessageDaoImpl();
	@Override
	public void makeMessage(int rID) {
		messageDao.createMessage(rID);

	}

	@Override
	public void addMessage(String message, String role, int rID) {
		messageDao.addMessage(message, role, rID);

	}

	@Override
	public Message findMessages(int rID) {
		return messageDao.getMessages(rID);
	}

	@Override
	public List<Message> findAllMessages() {
		return messageDao.getAllMessages();
	}

}
