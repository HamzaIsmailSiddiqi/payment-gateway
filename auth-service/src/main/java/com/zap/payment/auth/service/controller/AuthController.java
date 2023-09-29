package com.zap.wallet.token.service.controller;

import com.zap.wallet.common.request.user.LoginRequest;
import com.zap.wallet.common.request.user.LoginResponse;
import com.zap.wallet.token.service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/validate-login-otp")
    public ResponseEntity<?> validateLoginOtp(@RequestBody LoginRequest dto) throws Exception {
        LoginResponse response = authService.validateLoinOtp(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) throws Exception {
        authService.authenticateUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
