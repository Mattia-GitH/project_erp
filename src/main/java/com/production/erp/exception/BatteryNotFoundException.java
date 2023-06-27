package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BatteryNotFoundException extends RuntimeException{
    public BatteryNotFoundException(String msg){
        super(msg);
    }

    public BatteryNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
