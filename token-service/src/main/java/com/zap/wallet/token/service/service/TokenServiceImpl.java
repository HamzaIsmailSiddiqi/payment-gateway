package com.zap.wallet.token.service.service;

import com.zap.wallet.common.request.token.TokenDto;
import com.zap.wallet.common.utils.constants.TokenTypeConstants;
import com.zap.wallet.token.service.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public TokenDto generateToken(String userName) {
        TokenDto dto = new TokenDto();
        String token = jwtTokenUtil.generateToken(userName);
        dto.setToken(token);
        return dto;
    }

    @Override
    public void validateToken(String token) throws Exception {
        jwtTokenUtil.validateToken(token, TokenTypeConstants.ACCESS_TOKEN);
    }
}
