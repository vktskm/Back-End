package com.epicode.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/formlogin")
	public @ResponseBody String submit(@RequestParam String email, @RequestParam String password) {
		
		return "Email: " + email + " Pass: " + password;
	}
	
}
