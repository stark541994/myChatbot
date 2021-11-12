package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Message;
import com.example.demo.entity.service.MessageService;



@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	public MessageController(MessageService themessageService) {
		messageService = themessageService;
	}
	
	@MessageMapping("/message")
	@SendTo("/topic/return-to")
	public Message getContents(@RequestBody Message message) {
					message.setResponse(message.getContent());
			
					String response = messageService.findResponseByContent(message.getContent());
					
					message.setResponse(response);
		return message;
	}
	
	
	
}
