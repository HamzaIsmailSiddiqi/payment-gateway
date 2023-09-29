package com.zap.wallet.common.request.user;

import com.zap.wallet.common.request.BaseRequest;
import com.zap.wallet.common.request.token.TokenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse extends BaseRequest {

    private TokenDto tokenDetails;

}
