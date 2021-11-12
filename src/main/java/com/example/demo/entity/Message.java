package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="name")
	private String name;
	
	@Column(name="content")
	private String content;
	
	@Column(name="response")
	private String response;
	
	public Message() {
		
	}
		
	public Message(long id, String name, String content, String response) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.response = response;
	}

	public Message(String name, String content, String response) {
		super();
		this.name = name;
		this.content = content;
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	} 
	
	public int getId() {
		return (int) id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", content=" + content + ", response=" + response + "]";
	}
	
}
