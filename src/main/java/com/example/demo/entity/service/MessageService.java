package com.example.demo.entity.service;

import java.util.List;

import com.example.demo.entity.Message;

public interface MessageService {
	
	public String findResponseByContent(String content);

	public List<Message> findAll();
	
	public void saveMessage(Message message);
	
	public List<Message> findContentByResponse();

}
