package com.zap.wallet.common.request.user;

import com.zap.wallet.common.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginRequest extends BaseRequest {

    private String userName;
    private String pin;
    private String otp;

}
