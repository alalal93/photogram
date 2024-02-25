package com.cos.photogramstart.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;

@RestController
@ControllerAdvice
public class ControllerExcptionHandler {

	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) {
		
		//CmRespDto, Script 비교
		//1.클라이언트에게 응답할 때는 Script 좋음.
		//2.Ajax통신 - CmRespDto
		//3.Android통신 - CMrespDto
		return Script.back(e.getErrorMap().toString());
	}

	// public CMRespDto<Map<String, String>>
	// validationException(CustomValidationException e) {

//		return new CMRespDto(-1, e.getMessage(), e.getErrorMap(), e.getMessage());
//	}
}
