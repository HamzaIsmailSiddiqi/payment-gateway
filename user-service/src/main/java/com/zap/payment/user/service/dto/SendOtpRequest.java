package com.zap.payment.user.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendOtpRequest {

    private String countryCode;
    private String phoneNo;
    private String fullPhoneNo;
    private String clientIp;
    private String[] scopes;

}
