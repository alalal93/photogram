package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";		
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";		
	}
	
	//회원가입--> /auth/signup -> /ayth/signin
	// 회원가입버튼X
	@PostMapping("/auth/signup")
	public String signup() {
		return "auth/signin";		
	}
}
