package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IssuesNotFoundException extends RuntimeException{
    public IssuesNotFoundException(String msg){
        super(msg);
    }

    public IssuesNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
