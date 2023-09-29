package com.zap.payment.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateWalletRequest {

    @NotNull
    private Long userId;
    @NotNull
    private Long currencyId;
    @NotNull
    @NotEmpty
    private String address;
}
