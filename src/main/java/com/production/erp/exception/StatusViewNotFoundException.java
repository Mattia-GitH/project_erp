package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StatusViewNotFoundException extends RuntimeException{
    public StatusViewNotFoundException(String msg){
        super(msg);
    }

    public StatusViewNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}