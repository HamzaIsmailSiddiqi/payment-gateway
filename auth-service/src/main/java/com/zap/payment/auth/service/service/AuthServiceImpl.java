package com.zap.wallet.token.service.service;

import com.zap.wallet.common.exceptions.ZAPException;
import com.zap.wallet.common.request.otp.SendOtpRequest;
import com.zap.wallet.common.request.otp.ValidateOTPRequest;
import com.zap.wallet.common.request.token.TokenDto;
import com.zap.wallet.common.request.token.TokenRequest;
import com.zap.wallet.common.request.user.LoginRequest;
import com.zap.wallet.common.request.user.LoginResponse;
import com.zap.wallet.common.utils.constants.ResponseCodesConstants;
import com.zap.wallet.common.utils.constants.TokenTypeConstants;
import com.zap.wallet.token.service.clients.OtpServiceClient;
import com.zap.wallet.token.service.clients.TokenServiceClient;
import com.zap.wallet.token.service.model.UserProfileModel;
import com.zap.wallet.token.service.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private TokenServiceClient tokenServiceClient;
    @Autowired
    private OtpServiceClient otpServiceClient;
    @Autowired
    private UserProfileRepository userProfileRepository;

    private UserProfileModel loadAndValidateUser(LoginRequest dto) throws Exception {
        UserProfileModel model = userProfileRepository.findByUserName(dto.getUserName());
        if(model == null) {
            throw new ZAPException(ResponseCodesConstants.INTERNAL_ERROR, "invalid.credentials");
        }
        if(!Integer.toString(model.getPin()).equals(dto.getPin())) {
            throw new ZAPException(ResponseCodesConstants.INTERNAL_ERROR, "invalid.credentials");
        }
        return model;
    }

    @Override
    public void authenticateUser(LoginRequest request) throws Exception {
        UserProfileModel model = loadAndValidateUser(request);
        otpServiceClient.generateOtp(
                new SendOtpRequest(model.getCountryCode(), model.getPhoneNumber(), model.getPhoneNumber(), null, null)
        );
    }

    @Override
    public LoginResponse validateLoinOtp(LoginRequest request) throws Exception {
        UserProfileModel model = loadAndValidateUser(request);
        otpServiceClient.validateOtp(
                new ValidateOTPRequest(model.getPhoneNumber(), request.getOtp())
        );
        TokenDto tokenDto = tokenServiceClient.generateToken(
                new TokenRequest(request.getUserName(), TokenTypeConstants.ACCESS_TOKEN));
        //
        LoginResponse response = new LoginResponse();
        response.setTokenDetails(tokenDto);
        return response;
    }
}
