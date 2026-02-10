package com.enterpriseflow.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.enterpriseflow.constant.ErrorMessage;
import com.enterpriseflow.response.ApiResponse;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest()
                .body(ApiResponse.error("Validation failed", errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneric(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Something went wrong", null));
    }
	
}