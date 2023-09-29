package com.zap.payment.user.service.service.impl;

import com.spring.boot.practice.utils.constants.AccountStatusConstants;
import com.zap.payment.user.service.exceptions.CustomValidationException;
import com.zap.payment.user.service.exceptions.ErrorCode;
import com.zap.payment.user.service.exceptions.ZAPException;
import com.zap.payment.user.service.model.UserProfile;
import com.zap.payment.user.service.repository.UserProfileRepository;
import com.zap.payment.user.service.dto.CreateUserRequest;
import com.zap.payment.user.service.dto.UserInfoDto;
import com.zap.payment.user.service.service.UserService;
import com.zap.payment.user.service.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Transactional
    @Override
    public void createUser(CreateUserRequest request) {
        StringBuilder sb = isValidCreateUserRequest(request);
        if (sb.length() > 0) {
            throw new CustomValidationException(ccom.zap.payment.user.service.utils.constants.ResponseCodeConstants.GENERAL_ERROR_CODE, sb.toString());
        }
        UserInfoDto info = request.getUserInfo();
        UserProfile profileModel = new UserProfile();
        profileModel.setUserId(request.getUserId());
        profileModel.setUserName(request.getUserName());
        profileModel.setEmail(info.getEmail());
        profileModel.setCountryCode(request.getCountryCode());
        profileModel.setFirstName(info.getFirstName());
        profileModel.setLastName(info.getLastName());
        profileModel.setImageUrl(info.getImageUrl());
        profileModel.setPhoneNumber(request.getPhoneNumber());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        //convert String to LocalDate
        profileModel.setDob(LocalDate.parse(info.getDob(), formatter));
        profileModel.setPassword(request.getPassword());
        profileModel.setPin(Integer.parseInt(request.getPin()));
        profileModel.setFingerPrint(request.getFingerPrint());
        profileModel.setAccountStatus(AccountStatusConstants.ACTIVE);
        profileModel.setKycVerifiedBy(null);
        profileModel.setLoginBlocked(Boolean.FALSE);
        profileModel.setMaxOtpRetryCount(5);
        profileModel.setOtpVerified("Yes");
        profileModel.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userProfileRepository.saveAndFlush(profileModel);
        //

    }

    private StringBuilder isValidCreateUserRequest(CreateUserRequest request) {
        StringBuilder sb = new StringBuilder();
        ValidationUtil.doValidate(sb, "User Name", request.getUserName(), 0, 0, false);
        ValidationUtil.doValidate(sb, "Country Code", request.getCountryCode(), 0, 0, false);
        return sb;
    }

    @Override
    public UserProfile fetchUserProfileById(Long id) {
        return userProfileRepository
                .findById(id)
                .orElseThrow(() -> new ZAPException(ErrorCode.INVALID_PARAMETER));
    }

}
