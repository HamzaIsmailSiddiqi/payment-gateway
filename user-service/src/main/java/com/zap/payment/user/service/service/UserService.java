package com.zap.payment.user.service.service;


import com.zap.payment.user.service.model.UserProfile;
import com.zap.payment.user.service.dto.CreateUserRequest;

public interface UserService {

    void createUser(CreateUserRequest request);

    UserProfile fetchUserProfileById(Long id);
}
