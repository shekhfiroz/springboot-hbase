package com.is.cw.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.is.cw.dto.LoginRequestDto;
import com.is.cw.dto.SignUpRequestDto;
import com.is.cw.entity.User;
import com.is.cw.repository.UserRepository;
import com.is.cw.service.UserService;

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

	@Override
	public User save(SignUpRequestDto request) {
		return userRepository.save(request.getUsername(), request.getEmail(), request.getPassword());
	}

	@Override
	public User findByEmailAndPassword(LoginRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
