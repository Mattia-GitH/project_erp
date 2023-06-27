package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShippingNotFoundException extends RuntimeException{
    public ShippingNotFoundException(String msg){
        super(msg);
    }

    public ShippingNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
