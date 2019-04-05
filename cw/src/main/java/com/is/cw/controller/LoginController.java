package com.is.cw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.is.cw.dto.LoginRequestDto;
import com.is.cw.dto.SignUpRequestDto;
import com.is.cw.entity.User;
import com.is.cw.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	private UserService userService;
	
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/sign-up")
	public ModelAndView signUp() {
		ModelAndView mv = new ModelAndView("sign-up");
		mv.addObject("signUpRequestDto", new SignUpRequestDto());
		return mv;
	}

	@PostMapping("/sign-up")
	public String submitForm(@ModelAttribute SignUpRequestDto signUpRequestDto) {
		LOG.info("Request Object {}", signUpRequestDto);
		User savedUser = userService.save(signUpRequestDto);
		return "success";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginForm", new LoginRequestDto());
		return mv;
	}

	@PostMapping("/login")
	public ModelAndView submitLoginForm(@ModelAttribute LoginRequestDto request) {
		//User user = userService.findByEmailAndPassword(request);
		User user = new User("Feroz", "f@gmail.com", "123");
		ModelAndView mv = new ModelAndView();
		if (user == null) {
			LOG.error("No such user found");
			mv.setViewName("error");
			return mv;
		}
		mv = new ModelAndView("dashboard");
		mv.addObject("users", getDummyUsers());
		mv.addObject("currentUser", user);

		return mv;
	}
	
	private List<User> getDummyUsers() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			users.add(new User("Feroz" + i, "feroz@gmail.com", i + ""));
		return users;
	}

}
