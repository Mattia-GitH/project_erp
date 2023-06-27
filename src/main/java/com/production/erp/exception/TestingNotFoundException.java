package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestingNotFoundException extends RuntimeException{
    public TestingNotFoundException(String msg){
        super(msg);
    }

    public TestingNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
