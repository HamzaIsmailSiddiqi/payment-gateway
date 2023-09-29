package com.zap.wallet.token.service.repository;


import com.zap.wallet.token.service.model.UserProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileModel, Long>,
        QueryByExampleExecutor<UserProfileModel> {

    UserProfileModel findByUserName(String userName);

}
