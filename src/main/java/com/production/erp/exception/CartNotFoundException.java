package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String msg){
        super(msg);
    }

    public CartNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
