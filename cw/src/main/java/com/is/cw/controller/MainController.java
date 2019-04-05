package com.is.cw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@GetMapping(value = { "/", "/welcome" })
	public String welcome() {
		LOG.info("Inside Welcome method.");
		return "welcome";
	}

	@GetMapping("/success")
	public String sucess() {
		return "success";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
