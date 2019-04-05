package com.is.cw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.is.cw.entity.User;
import com.is.cw.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public ModelAndView getUsers() {
		List<User> users = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("user-list");
		modelAndView.addObject("userList", users);
		return modelAndView;
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView getUserDetails(@PathVariable String id) {
		//User user = userService.getUserById(id);
		User user = new User("Feroz", "F@gmail.com", "123123");
		ModelAndView mv = new ModelAndView("user-details");
		mv.addObject("user", user);
		return mv;
	}
	
}
