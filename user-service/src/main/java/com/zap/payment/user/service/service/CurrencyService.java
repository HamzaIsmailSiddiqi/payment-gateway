package com.zap.payment.user.service.service;

import com.zap.payment.user.service.model.Currency;

public interface CurrencyService {

    Currency fetchCurrencyById(Long id);
}
