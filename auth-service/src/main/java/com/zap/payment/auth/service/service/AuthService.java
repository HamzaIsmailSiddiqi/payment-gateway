package com.zap.wallet.token.service.service;

import com.zap.wallet.common.request.user.LoginRequest;
import com.zap.wallet.common.request.user.LoginResponse;

public interface AuthService {

    void authenticateUser(LoginRequest dto) throws Exception;

    LoginResponse validateLoinOtp(LoginRequest request) throws Exception;

}
