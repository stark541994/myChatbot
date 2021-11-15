package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query("SELECT u.response FROM Message u WHERE u.content = ?1")
	String findResponseByContent(String content);

	
	
	//@Query("Select u.content FROM Message u WHERE u.response ='I am not sure what to answer that. I'll let this know to our Administrator'")
	@Query("SELECT u.content FROM Message u WHERE u.response = ?1")
	List findContentByResponse(String response);
}
