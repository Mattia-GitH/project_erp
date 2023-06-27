package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanningNotFoundException extends RuntimeException{
    public PlanningNotFoundException(String msg){
        super(msg);
    }

    public PlanningNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}