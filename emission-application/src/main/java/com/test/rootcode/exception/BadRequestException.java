package com.test.rootcode.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -5659566025114722555L;
    private final String value;
    private final String message;

    public BadRequestException(String message,String value){
        super(String.format("%s  : '%s'",message,value));

        this.value = value;
        this.message = message;
    }
}

