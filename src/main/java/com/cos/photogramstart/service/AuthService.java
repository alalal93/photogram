package com.cos.photogramstart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service// 1.Ioc 2.트랜잭션관리
public class AuthService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional //Write(Insert, Update, Delete)
	public  User 회원가입(User user) { // 회원가입 메서드에 매개변수로 존재하는 User 오브젝트는 외부에서 클라이언트가 통신을 통해서 전송받은데이터
		// 회원가입 진행
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER"); //관리자 ROLE_ADMIN
		User userEntity = userRepository.save(user); // userRepository.save()통해서 받은 User 오브젝트는 DB에 있는 데이터를 응답받은것
		// 내가받은 데이터가 User 오브젝트 타입이므로 타입도 User return도 DB에서 받은 User 오브젝트인 userIntity를 해준다.
		return userEntity;
	}
}
