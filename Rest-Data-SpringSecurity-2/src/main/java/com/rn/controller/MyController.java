package com.rn.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rn.entity.User;

@RestController
public class MyController {

	@Autowired
	private RestTemplate template;

	// @GetMapping("/user")
	@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String user() {
		return " From User ";
	}

	// @GetMapping("/admin")
	@RequestMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String admin() {
		return " From Admin ";
	}

	@GetMapping("/")
	public String home() {
		return "<h1>From Home</h1>";
	}

	@RequestMapping(value = "/logmeout", method = RequestMethod.POST)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}

	@GetMapping(path = "/getuser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getAllUser(@PathVariable("id") String id) {

		List<User> userList = Arrays.asList(new User("roshan", 12, "ngp"), new User("Shubham", 12, "ngp"),
				new User("Rohit", 12, "ngp"));
		return userList;
	}
}
