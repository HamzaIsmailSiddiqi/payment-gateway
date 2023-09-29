package com.zap.payment.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class CreateUserRequest {

    private Long userId;
    @NotEmpty(message = "User Name is required.")
    private String userName;
    @NotEmpty(message = "Country Code is required.")
    private String countryCode;
    private UserInfoDto userInfo;
    @NotEmpty(message = "Phone Number is required.")
    private String phoneNumber;
    private String password;
    @NotEmpty(message = "PIN is required.")
    private String pin;
    private String fingerPrint;
    private Boolean activation;

}
