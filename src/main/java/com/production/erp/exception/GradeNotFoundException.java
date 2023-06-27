package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GradeNotFoundException extends RuntimeException{
    public GradeNotFoundException(String msg){
        super(msg);
    }

    public GradeNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
