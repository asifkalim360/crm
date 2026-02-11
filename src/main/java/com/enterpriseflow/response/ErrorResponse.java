package com.enterpriseflow.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class ErrorResponse {
	
	// internal error tracking code(jaise AUTH_001)
	private String errorCode;
	
	// user friendly message 
	private String message; 
	
	// http status 
	private int status; 
	
	// request ka path 
	private String path; 
	
	//validation errors (optional). 
	private List<String> errors; 
	
	// timestamp. 
	private LocalDateTime timestamp; 
	
	//===================== Staic method - simple error =========================
	public static ErrorResponse of(String errorCode, String message, int status, String path)
	{
		return ErrorResponse.builder()
				.errorCode(errorCode)
				.message(message)
				.status(status)
				.path(path)
				.errors(null)
				.timestamp(LocalDateTime.now())
				.build();
	}
	
	//===================== Staic method - validation error =========================
		public static ErrorResponse validation(String errorCode,List<String> errors, int status, String path)
		{
			return ErrorResponse.builder()
					.errorCode(errorCode)
					.message("Validation Failed")
					.status(status)
					.path(path)
					.errors(errors)
					.timestamp(LocalDateTime.now())
					.build();
		}
	
	
}