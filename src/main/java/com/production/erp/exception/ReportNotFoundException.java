package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReportNotFoundException extends RuntimeException{
    public ReportNotFoundException(String msg){
        super(msg);
    }

    public ReportNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
