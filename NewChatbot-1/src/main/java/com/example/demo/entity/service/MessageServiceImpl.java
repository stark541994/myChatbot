package com.example.demo.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

private MessageRepository messageRepository;
	
	@Autowired
	public MessageServiceImpl(MessageRepository theMessageRepository) {
		messageRepository = theMessageRepository;
	}
	
	@Override
	public String findResponseByContent(String content) {
		return messageRepository.findResponseByContent(content);
	}

	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}
}
