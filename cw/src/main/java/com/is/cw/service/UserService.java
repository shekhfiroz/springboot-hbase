package com.is.cw.service;

import java.util.List;

import com.is.cw.dto.LoginRequestDto;
import com.is.cw.dto.SignUpRequestDto;
import com.is.cw.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User save(SignUpRequestDto request);
	
	public User findByEmailAndPassword(LoginRequestDto request);

	public User getUserById(String id);
}



