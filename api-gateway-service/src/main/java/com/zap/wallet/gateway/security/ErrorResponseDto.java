package com.zap.wallet.gateway.security;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ErrorResponseDto implements Serializable {

    Date date;
    int value;
    String unauthorized;
    List<String> details;
    String s;
    public ErrorResponseDto(Date date, int value, String unauthorized, List<String> details, String s) {

        this.date = date;
        this.value = value;
        this.unauthorized = unauthorized;
        this.details = details;
        this.s = s;
    }
}
