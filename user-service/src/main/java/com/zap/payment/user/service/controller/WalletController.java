package com.zap.payment.user.service.controller;

import com.zap.payment.user.service.dto.CreateWalletRequest;
import com.zap.payment.user.service.dto.WalletDto;
import com.zap.payment.user.service.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("wallet/")
@RequestMapping
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WalletDto> createWallet(@RequestBody @Validated CreateWalletRequest request) {
        WalletDto wallet = walletService.createWallet(request);
        return new ResponseEntity<>(wallet, HttpStatus.CREATED);
    }

}

