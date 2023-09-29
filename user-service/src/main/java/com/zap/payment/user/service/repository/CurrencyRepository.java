package com.zap.payment.user.service.repository;

import com.zap.payment.user.service.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CurrencyRepository extends JpaRepository<Currency, Long>, QueryByExampleExecutor<Currency> {

}
