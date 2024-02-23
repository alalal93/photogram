package com.cos.photogramstart.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.UserRepository;

@Service// 1.Ioc 2.트랜잭션관리
public class AuthService {
	
	private final UserRepository userRepository;
	
	
	public void User 회원가입(User user) {
		// 회원가입 진행
		User userEntity = userRepository.save(user);
		return userEntity;
	}
}
