package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanningPreviewNotFound extends RuntimeException{
    public PlanningPreviewNotFound(String msg){
        super(msg);
    }

    public PlanningPreviewNotFound(String msg, Throwable throwable){
        super(msg, throwable);
    }
}