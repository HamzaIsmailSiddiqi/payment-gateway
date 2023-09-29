package com.zap.wallet.gateway.clients;

import com.zap.wallet.common.request.token.TokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "token-service/api/token")
public interface TokenServiceClient {

    @PostMapping(value = "authenticate")
    ResponseEntity<?> authenticateToken(@RequestBody TokenDto tokenDto);

}
