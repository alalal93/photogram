package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;
	
@RequiredArgsConstructor //final필드 DI할때 사용
@Controller
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthService authService;
	
//	public AuthController(AuthService authService) {
//		this.authService = authService;
//	}

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
	public String signup(SignupDto signupDto) {//key=value(x-www-form-urlencoded)
		log.info(signupDto.toString());
		// User <-- Signup Dto
		User user = signupDto.toEntity();
		log.info(user.toString());
		User userEntity = authService.회원가입(user);
		
		System.out.println(userEntity);
		return "auth/signin";
	}
}
