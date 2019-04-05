package com.is.cyberwatch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.is.cyberwatch.dto.SignUpRequestDto;
import com.is.cyberwatch.entity.User;
import com.is.cyberwatch.service.UserService;

@Controller
public class MainController {

	private UserService userService;

	public MainController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/sign-up")
	public String signUp() {
		return "home";
	}

	@PostMapping("/sign-up")
	public String submitForm(@RequestParam @Valid SignUpRequestDto request) {
		return "home";
	}

	@GetMapping("/user")
	public ModelAndView getUsers() {
		List<User> users = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("user-list");
		modelAndView.addObject("userList", users);
		return modelAndView;
	}
}