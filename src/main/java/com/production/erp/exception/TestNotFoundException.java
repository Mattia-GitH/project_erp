package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestNotFoundException extends RuntimeException{
    public TestNotFoundException(String msg){
        super(msg);
    }

    public TestNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
