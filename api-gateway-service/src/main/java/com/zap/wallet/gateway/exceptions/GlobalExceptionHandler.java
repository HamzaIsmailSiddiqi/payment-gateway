package com.zap.wallet.gateway.exceptions;

import com.zap.wallet.common.exceptions.CustomValidationException;
import com.zap.wallet.common.exceptions.InvalidTokenException;
import com.zap.wallet.common.exceptions.ZAPException;
import com.zap.wallet.common.exceptions.config.ApiError;
import com.zap.wallet.common.utils.constants.ResponseCodesConstants;
import com.zap.wallet.gateway.configuration.ResponseMessagesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseMessagesConfig responseMessagesConfig;
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
        apiError.setResponseMessage(responseMessagesConfig.getPropertyValue(ex.getErrorMessageKey()));
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<?> handleUnAuthorizedException(InvalidTokenException ex) {
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED);
        apiError.setResponseCode(ResponseCodesConstants.INTERNAL_ERROR);
        apiError.setResponseMessage(responseMessagesConfig.getPropertyValue("invalid.token"));
        return buildResponseEntity(apiError);
    }

}
