package com.zap.wallet.common.request.otp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class ValidateOTPRequest {

    private String mobileNo;
    private String otpCode;
}
