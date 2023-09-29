package com.zap.payment.user.service.repository;


import com.zap.payment.user.service.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>, QueryByExampleExecutor<UserProfile> {
}
