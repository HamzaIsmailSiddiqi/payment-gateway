package com.zap.payment.user.service.dto;

import com.zap.payment.user.service.model.UserProfile;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class WalletDto {

    private Long walletId;
    private BigDecimal balance;
    private UserProfile userProfile;
    private Long userId;
    private String userName;
    private String currencyName;
    private String abbreviation;

}
