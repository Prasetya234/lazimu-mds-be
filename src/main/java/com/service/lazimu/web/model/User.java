package com.service.lazimu.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "VARCHAR(255)", unique=true)
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Column(name = "email")
    private String emailAddress;

    @Column(name = "password_hash")
    private String passwordHash;

    public User(String username, String mobilePhoneNumber, String emailAddress, String passwordHash) {
        this.username = username;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
        this.passwordHash = passwordHash;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
