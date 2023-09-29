package com.zap.wallet.common.request.otp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class SendOtpRequest {

    @NotEmpty(message = "Country Code cannot be empty or null.")
    private String countryCode;
    @NotEmpty(message = "Phone No. cannot be empty or null.")
    private String phoneNo;
    @NotEmpty(message = "Full Phone No. cannot be empty or null.")
    private String fullPhoneNo;
    private String clientIp;
    private String[] scopes;

}
