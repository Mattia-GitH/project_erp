package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolishNotFoundException extends RuntimeException{
    public PolishNotFoundException(String msg){
        super(msg);
    }

    public PolishNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
