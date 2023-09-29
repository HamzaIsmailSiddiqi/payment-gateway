package com.zap.wallet.token.service.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_userprofile")
public class UserProfileModel implements Serializable {

    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String phoneNumber;
    private LocalDate dob;
    private String countryCode;
    private String password;
    private Integer pin;
    private String fingerPrint;
    private String accountStatus;
    private String otpVerified;
    private Timestamp createdAt;
    private String kycVerifiedBy;
    private Integer maxOtpRetryCount;
    private Boolean isLoginBlocked;

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_userprofile_seq")
    @SequenceGenerator(name = "tbl_userprofile_seq", sequenceName = "tbl_userprofile_seq", allocationSize = 1)
    @Column(name = "userid")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "username", nullable = false, unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "dob")
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "pin")
    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    @Column(name = "finger_print")
    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    @Column(name = "account_status")
    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Column(name = "otp_verified")
    public String getOtpVerified() {
        return otpVerified;
    }

    public void setOtpVerified(String otpVerified) {
        this.otpVerified = otpVerified;
    }

    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "kyc_verifiedby")
    public String getKycVerifiedBy() {
        return kycVerifiedBy;
    }

    public void setKycVerifiedBy(String kycVerifiedBy) {
        this.kycVerifiedBy = kycVerifiedBy;
    }

    @Column(name = "max_otp_retry_count")
    public Integer getMaxOtpRetryCount() {
        return maxOtpRetryCount;
    }

    public void setMaxOtpRetryCount(Integer maxOtpRetryCount) {
        this.maxOtpRetryCount = maxOtpRetryCount;
    }

    @Column(name = "login_blocked")
    public Boolean getLoginBlocked() {
        return isLoginBlocked;
    }

    public void setLoginBlocked(Boolean loginBlocked) {
        isLoginBlocked = loginBlocked;
    }
}
