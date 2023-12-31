package com.zap.wallet.common.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zap.wallet.common.request.token.TokenDto;
import com.zap.wallet.common.response.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class UserDetailsResponse extends BaseResponse {

    private TokenDto tokenDetails;

}
