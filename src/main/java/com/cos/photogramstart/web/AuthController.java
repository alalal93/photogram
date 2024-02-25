package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;
	


@RequiredArgsConstructor //final필드 DI할때 사용 final걸린 애들을 골라서 생성자를 자동으로 만들어준다
@Controller
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired // 첫번째방법 AutoController 가 AuthService를 의존하는관계 따라서 의존성 주입(DI를받아야한다)
						//Controller 어노테이션이 붙어있으면 springboot가 authcontroller를 IOC컨테이너 관리하고있는 메모리에다가
						//객체를 생성해서 Load해주는데 객체생성시 조건이필요하다 생성자를 만들어주는것 생성자를 실행시킬땐 Ioc컨테이너 등록되잇는
						//데이터를 찾아 매개변수로 넣게됨 그걸찾아서 생성자에게 주입한후 컨트롤러가 Ioc컨테이너에 등록이되는것
	
	
	// 세번째방법 의존성을 주입받을 AuthService에 final을 걸고 컨트롤러에 어노테이션 걸어주는방법
	private final AuthService authService;
	
	// 두번째방법 AuthController의 생성자를 만들어서 의존성을 주입받음
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
	
	//회원가입--> /auth/signup -> /auth/signin
	// 회원가입버튼X
	@PostMapping("/auth/signup")
	public String signup(SignupDto signupDto) {//key=value(x-www-form-urlencoded)
		log.info(signupDto.toString());
		// User <-- Signup Dto
		// User object에 Signup Dto 데이터를 삽입하려고 한다.
		
		// User 오브젝트에 signDto에서 방금 만들었던 toEntity 데이터를 넣어주자
		User user = signupDto.toEntity();
		log.info(user.toString());
		User userEntity = authService.회원가입(user);
		System.out.println(userEntity);
		return "auth/signin";
	}
}
