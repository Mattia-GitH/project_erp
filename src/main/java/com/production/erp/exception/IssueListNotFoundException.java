package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IssueListNotFoundException extends RuntimeException{
    public IssueListNotFoundException(String msg){
        super(msg);
    }

    public IssueListNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
