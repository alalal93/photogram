package com.cos.photogramstart.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.user.UserProfileDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;

	@GetMapping("/user/{pageUserId}")
	public String profile(@PathVariable int pageUserId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		UserProfileDto dto = userService.회원프로필(pageUserId, principalDetails.getUser().getId());
		model.addAttribute("dto",dto);
		return "user/profile";
	}
	
	@GetMapping("user/{id}/update")
	
	
	// 어노테이션 사용
	public String update(@PathVariable int id,@AuthenticationPrincipal PrincipalDetails principalDetails) {
//		System.out.println("세션정보:"+principalDetails.getUser());

	// 어노테이션 미사용
//		Authentication auth =SecurityContextHolder.getContext().getAuthentication();//
//		PrincipalDetails mPrincipalDetails = (PrincipalDetails)auth.getPrincipal();
//		System.out.println("직접 찾은 세션 정보 :" +mPrincipalDetails.getUser());
		
		// 세션 가져오기 모델 Model model
		// model.addAttribute("principal",principalDetails.getUser()); 이방법 안쓰고 시큐리티 태그라이브 사용
		return "user/update";
	}
}
