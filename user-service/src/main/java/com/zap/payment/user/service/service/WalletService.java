package com.zap.payment.user.service.service;

import com.zap.payment.user.service.dto.CreateWalletRequest;
import com.zap.payment.user.service.dto.WalletDto;

public interface WalletService {

    WalletDto createWallet(CreateWalletRequest request);
}
