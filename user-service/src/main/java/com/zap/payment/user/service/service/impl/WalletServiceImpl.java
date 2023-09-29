package com.zap.payment.user.service.service.impl;

import com.zap.payment.user.service.model.Wallet;
import com.zap.payment.user.service.repository.WalletRepository;
import com.zap.payment.user.service.dto.CreateWalletRequest;
import com.zap.payment.user.service.dto.WalletDto;
import com.zap.payment.user.service.service.CurrencyService;
import com.zap.payment.user.service.service.UserService;
import com.zap.payment.user.service.service.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {

    private final CurrencyService currencyService;
    private final UserService userService;
    private final WalletRepository walletRepository;

    public WalletServiceImpl(CurrencyService currencyService, UserService userService, WalletRepository walletRepository) {
        this.currencyService = currencyService;
        this.userService = userService;
        this.walletRepository = walletRepository;
    }

    @Override
    public WalletDto createWallet(CreateWalletRequest request) {

        Wallet wallet = new Wallet();
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setUserProfile(userService.fetchUserProfileById(request.getUserId()));
        wallet.setCurrency(currencyService.fetchCurrencyById(request.getCurrencyId()));
        wallet = walletRepository.save(wallet);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(wallet, WalletDto.class);
    }
}
