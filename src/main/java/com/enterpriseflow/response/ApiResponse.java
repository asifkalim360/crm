package com.enterpriseflow.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    // T generic type hai, matlab data kisi bhi type ka ho sakta hai
    private boolean success;

    private String message;

    private T data;

    private LocalDateTime timestamp;

}
