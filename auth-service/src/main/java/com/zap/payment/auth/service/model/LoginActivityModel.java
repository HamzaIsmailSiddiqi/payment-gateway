package com.zap.wallet.token.service.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_userprofile")
public class LoginActivityModel implements Serializable {

    private Integer loginId;
    private Integer userId;
    private Boolean isVerificationDone;
    private String isOtpVerified;
    private LocalDateTime loginTime;
    private LocalDateTime logOutTime;
    private Integer otpRetryCount;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_loginactivity_seq")
    @SequenceGenerator(name = "tbl_loginactivity_seq", sequenceName = "tbl_loginactivity_seq", allocationSize = 1)
    @Column(name = "loginid")
    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    @Column(name = "userid", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "verification_done")
    public Boolean getVerified() {
        return isVerificationDone;
    }

    public void setVerified(Boolean verified) {
        isVerificationDone = verified;
    }

    @Column(name = "otp_verified")
    public String getOtpVerified() {
        return isOtpVerified;
    }

    public void setOtpVerified(String otpVerified) {
        isOtpVerified = otpVerified;
    }

    @Column(name = "login_time", nullable = false)
    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    @Column(name = "logout_time")
    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalDateTime logOutTime) {
        this.logOutTime = logOutTime;
    }

    @Column(name = "otp_retry_count", nullable = false)
    public Integer getOtpRetryCount() {
        return otpRetryCount;
    }

    public void setOtpRetryCount(Integer otpRetryCount) {
        this.otpRetryCount = otpRetryCount;
    }

}
