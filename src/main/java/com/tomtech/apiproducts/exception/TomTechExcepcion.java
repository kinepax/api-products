package com.tomtech.apiproducts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class TomTechExcepcion extends RuntimeException{


    private HttpStatus status;
    private String description = " ";



    public TomTechExcepcion(HttpStatus status, String description){
        this.status=status;
        this.description=description;


    }


    public TomTechExcepcion(HttpStatus status){
        this.status=status;
        this.description= "Error desconocido";

    }
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //...


}
