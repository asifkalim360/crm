package com.enterpriseflow.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class ErrorResponse {
	
	// error code internal tracking ke liye.
	private String errorCode; 
	
	// error message.
	private String message; 
	
	// http status.
	private int status; 
	
	// kis path pe error aaya.
	private String path; 
	
	// timestamp.
	private LocalDateTime timestamp;
	
}