package com.zap.payment.user.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateOTPRequest {

    private String clientIp;
    private String otpCode;
}
