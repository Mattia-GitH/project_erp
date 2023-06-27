package com.production.erp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String msg){
        super(msg);
    }

    public ArticleNotFoundException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
