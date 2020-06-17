package com.nt.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	@GetMapping("/user")
	public String showUser(Principal p) {
		OAuth2Authentication outh = (OAuth2Authentication) p;
		Map<String, Object> map = (Map<String, Object>) outh.getUserAuthentication().getDetails();
		return "welcome" + map.get("name");
	}

	@GetMapping("/")
	public String showHome() {
		return "Welcome to All";
	}

	@GetMapping("/inbox")
	public String showInbox() {
		return "Welcome to Inbox";
	}
}
