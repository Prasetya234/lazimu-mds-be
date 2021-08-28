package com.service.lazimu.web.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank(message = "Username CANNOT BE EMPTY")
    private String username;

    @NotBlank(message = "Mobile Phone Number CANNOT BE EMPTY")
    private String mobilePhoneNumber;

    @NotBlank(message = "Email CANNOT BE EMPTY")
    private String emailAddress;

    @NotBlank(message = "Password CANNOT BE EMPTY")
    private String passwordHash;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
