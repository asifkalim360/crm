package com.enterpriseflow.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    // request success hua ya fail.
    private boolean success;

    // http status code store karenge.
    private int statusCode;
    
    //user friendly message.
    private String message;

    // T generic type hai, matlab data kisi bhi type ka ho sakta hai
    //actual data
    private T data;

    // response ka time
    private LocalDateTime timestamp;
    
    
    // ✅ Success with data. 
    public static <T> ApiResponse<T> success(String message, T data, int statusCode)
    {
    	return ApiResponse.<T>builder()
    			.success(true)
    			.statusCode(statusCode)
    			.message(message)
    			.data(data)
    			.timestamp(LocalDateTime.now())
    			.build();
    }
    
    // ✅ Success without data. 
    public static <T> ApiResponse<T> success(String message, int statusCode)
    {
    	return ApiResponse.<T>builder()
    			.success(true)
    			.statusCode(statusCode)
    			.message(message)
    			.data(null)
    			.timestamp(LocalDateTime.now())
    			.build();
    }
    
    // ❌ Failure
    public static <T> ApiResponse<T> failure(String message, int statusCode)
    {
    	return ApiResponse.<T>builder()
    			.success(false)
    			.statusCode(statusCode)
    			.message(message)
    			.data(null)
    			.timestamp(LocalDateTime.now())
    			.build();
    }


}
