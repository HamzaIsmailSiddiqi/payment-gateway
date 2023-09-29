package com.zap.payment.user.service.repository;

import com.zap.payment.user.service.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface WalletRepository extends JpaRepository<Wallet, Long>, QueryByExampleExecutor<Wallet> {
}
