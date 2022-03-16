package com.example.projetcomplementgl.services;

import com.example.projetcomplementgl.entities.exception.BadRequestException;
import org.springframework.http.HttpStatus;

public class ExceptionService {
    private ExceptionService() {
    }

    public static HttpStatus getHttpCode(Exception e){
        if (e instanceof BadRequestException)
            return HttpStatus.BAD_REQUEST;
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
