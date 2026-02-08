package com.enterpriseflow.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.enterpriseflow.constant.ErrorMessage;
import com.enterpriseflow.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice		//pura application ke liye global exception handler
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex, HttpServletRequest request)
	{
		ErrorResponse builderResponse = ErrorResponse.builder()
				.errorCode("BUSINESS ERROR")
				.message(ex.getMessage())
				.status(HttpStatus.BAD_REQUEST.value())
				.path(request.getRequestURI())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(builderResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, HttpServletRequest request)
	{		
	ErrorResponse respone = ErrorResponse.builder()
				.errorCode("INTERNAL_SERVER_ERROR")
				.message(ErrorMessage.INTERNAL_SERVER_ERROR)
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.path(request.getRequestURI())
				.timestamp(LocalDateTime.now())
				.build();
		return new ResponseEntity<>(respone, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}