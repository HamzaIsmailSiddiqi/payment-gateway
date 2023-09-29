package com.zap.wallet.token.service.service;

import com.zap.wallet.common.request.token.TokenDto;

public interface TokenService {

    TokenDto generateToken(String userName);

    void validateToken(String token) throws Exception;

}
