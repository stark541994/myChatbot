package com.example.demo.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.example.demo.entity.CustomeUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class CustomeUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findbyEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!!");
		}
		return new CustomeUserDetails(user);
	}
	

}
