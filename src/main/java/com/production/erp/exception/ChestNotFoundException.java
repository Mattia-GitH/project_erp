package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ChestNotFoundException extends RuntimeException{
    public ChestNotFoundException(String msg){
        super(msg);
    }

    public ChestNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
