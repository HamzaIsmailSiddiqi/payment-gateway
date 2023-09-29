package com.zap.wallet.token.service.controller;

import com.zap.wallet.common.exceptions.CustomValidationException;
import com.zap.wallet.common.exceptions.ZAPException;
import com.zap.wallet.common.exceptions.config.ApiError;
import com.zap.wallet.token.service.configuration.AuthErrorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private AuthErrorProperties errorProperties;

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

    @ExceptionHandler(ZAPException.class)
    public ResponseEntity<?> handleZAPException(ZAPException ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setResponseCode(ex.getErrorCode());
        apiError.setResponseMessage(errorProperties.getPropertyValue(ex.getErrorMessageKey()));
        return buildResponseEntity(apiError);
    }

}
