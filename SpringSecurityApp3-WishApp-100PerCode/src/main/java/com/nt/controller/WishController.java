package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishController {
	@Autowired
	private WishMessageService service;

	@RequestMapping("/home.htm")
	public String showHome() {
		return "welcome";
	}

	@RequestMapping("/wish.htm") // best signature
	public String process(Map<String, Object> map) {
		String msg = null;
		// use service
		msg = service.getWishMessage();
		// put model data
		map.put("wMsg", msg);
		// return lvn
		return "result";

	}
}
