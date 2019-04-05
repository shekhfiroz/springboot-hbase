package com.is.cyberwatch.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.is.cyberwatch.dao.UserRepository;
import com.is.cyberwatch.entity.User;
import com.is.cyberwatch.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	

}
