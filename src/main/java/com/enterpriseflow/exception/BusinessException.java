package com.enterpriseflow.exception;

public class BusinessException extends RuntimeException {
    // ye custom exception hai business logic errors ke liye.
    public BusinessException(String message)
    {
        super(message);
    }

}
