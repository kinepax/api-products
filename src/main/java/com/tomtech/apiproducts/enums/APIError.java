package com.tomtech.apiproducts.enums;

import org.springframework.http.HttpStatus;

public enum APIError {


    VALIDATION_ERROR(HttpStatus.BAD_REQUEST,"The are atrributes with wrong values"),
    BAD_FORMAT(HttpStatus.BAD_REQUEST,"The message not have a correct form"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND,"Product not found"),
    PRODUCT_WITH_SAME_ID(HttpStatus.BAD_REQUEST,"There is a product with the same id ");

    private final HttpStatus httpStatus;
    private final String message;


    APIError(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }




}
