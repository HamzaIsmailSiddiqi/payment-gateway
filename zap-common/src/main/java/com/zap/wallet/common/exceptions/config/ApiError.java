package com.zap.wallet.common.exceptions.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatus httpStatus;
    private LocalDateTime timeStamp;
    private String responseCode;
    private String responseMessage;

    private ApiError() {
        timeStamp = null;
    }

    public ApiError(HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;
    }

    public ApiError(HttpStatus httpStatus, Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.responseMessage = ex.getMessage();
    }

    public ApiError(HttpStatus httpStatus, String responseMessage) {
        this();
        this.httpStatus = httpStatus;
        this.responseMessage = responseMessage;
    }

}
