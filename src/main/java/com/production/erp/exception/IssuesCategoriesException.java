package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IssuesCategoriesException extends RuntimeException{
    public IssuesCategoriesException(String msg){
        super(msg);
    }

    public IssuesCategoriesException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
