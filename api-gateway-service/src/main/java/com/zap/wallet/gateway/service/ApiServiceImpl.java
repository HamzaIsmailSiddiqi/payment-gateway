package com.zap.wallet.gateway.service;

import com.zap.wallet.common.request.token.TokenDto;
import com.zap.wallet.gateway.clients.TokenServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private TokenServiceClient tokenServiceClient;

    @Override
    public void validateToken(String token) throws Exception {
        tokenServiceClient.authenticateToken(new TokenDto(token));
    }
}
