package com.zap.payment.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity buildResponseEntity(ApiError apiError) {
        return new ResponseEntity(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> handleValidationException(CustomValidationException ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setResponseCode(ex.getErrorCode());
        apiError.setResponseMessage(ex.getErrorMessage());
        return buildResponseEntity(apiError);
    }

}
