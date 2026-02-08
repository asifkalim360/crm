package com.enterpriseflow.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    // request success hua ya nahi.
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

}
