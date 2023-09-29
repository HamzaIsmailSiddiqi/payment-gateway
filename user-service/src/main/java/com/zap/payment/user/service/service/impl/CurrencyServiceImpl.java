package com.zap.payment.user.service.service.impl;

import com.zap.payment.user.service.exceptions.ErrorCode;
import com.zap.payment.user.service.exceptions.ZAPException;
import com.zap.payment.user.service.model.Currency;
import com.zap.payment.user.service.repository.CurrencyRepository;
import com.zap.payment.user.service.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency fetchCurrencyById(Long id) {
        return currencyRepository
                .findById(id)
                .orElseThrow(() -> new ZAPException(ErrorCode.INVALID_PARAMETER));
    }

}
