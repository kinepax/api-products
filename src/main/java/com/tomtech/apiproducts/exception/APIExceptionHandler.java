package com.tomtech.apiproducts.exception;

import com.tomtech.apiproducts.dto.ErrorDTO;
import com.tomtech.apiproducts.enums.APIError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {


    /*
    @ExceptionHandler(TomTechExcepcion.class)
    public ResponseEntity<String> handleTomTechExcepton(TomTechExcepcion ex){
        return new ResponseEntity<>(ex.getDescription(),ex.getStatus());
    }
*/

    @ExceptionHandler(TomTechExcepcion.class)
    public ResponseEntity<ErrorDTO> duplicateResource(TomTechExcepcion e , WebRequest request){


        return ResponseEntity.status(e.getStatus())
                .body(new ErrorDTO(e.getDescription(),e.getReasons()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex ,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request){
        List<String> reasons = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            reasons.add(String.format("%s - %s",error.getField(),error.getDefaultMessage()));
        }
        return ResponseEntity.status(APIError.VALIDATION_ERROR.getHttpStatus())
                .body(new ErrorDTO(APIError.VALIDATION_ERROR.getMessage(), reasons));

    }




}
