package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query("SELECT u.response FROM Message u WHERE u.content = ?1")
	String findResponseByContent(String content);
}
