package com.tomtech.apiproducts.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(TomTechExcepcion.class)
    public ResponseEntity<String> handleTomTechExcepton(TomTechExcepcion ex){
        return new ResponseEntity<>(ex.getDescription(),ex.getStatus());
    }


}
