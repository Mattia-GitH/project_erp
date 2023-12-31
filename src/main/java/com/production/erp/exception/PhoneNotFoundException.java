package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhoneNotFoundException extends RuntimeException{
    public PhoneNotFoundException(String msg){
        super(msg);
    }

    public PhoneNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
