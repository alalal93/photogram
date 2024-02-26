package com.cos.photogramstart.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

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


	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<CMRespDto<?>> validationException(CustomValidationApiException e) {
		System.out.println("======================나 실행됨??????===============");
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
	}
}
