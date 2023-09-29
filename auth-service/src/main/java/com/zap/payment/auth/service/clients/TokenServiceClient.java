package com.zap.wallet.token.service.clients;

import com.zap.wallet.common.request.token.TokenDto;
import com.zap.wallet.common.request.token.TokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "token-service/api/token")
public interface TokenServiceClient {

    @PostMapping(value = "generate")
    TokenDto generateToken(@RequestBody TokenRequest request);

    @PostMapping(value = "authenticate")
    ResponseEntity<?> authenticateToken(@RequestBody String token);

}
