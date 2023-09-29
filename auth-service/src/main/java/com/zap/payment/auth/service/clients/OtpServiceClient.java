package com.zap.wallet.token.service.clients;

import com.zap.wallet.common.request.otp.SendOtpRequest;
import com.zap.wallet.common.request.otp.ValidateOTPRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "otp-service/api/otp")
public interface OtpServiceClient {

    @PostMapping(value = "generate")
    String generateOtp(@RequestBody SendOtpRequest request);

    @PostMapping(value = "validate")
    String validateOtp(@RequestBody ValidateOTPRequest request);

}
