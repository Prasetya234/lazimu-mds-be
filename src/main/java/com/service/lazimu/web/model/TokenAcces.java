package com.service.lazimu.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "access_token")
public class TokenAcces {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "VARCHAR(255)", unique=true)
    private String id;

    @Column(name = "expired_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Date expridedDate;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "email")
    private String email;

    public TokenAcces() {
    }

    public TokenAcces(Date expridedDate, String code, String email) {
        this.expridedDate = expridedDate;
        this.code = code;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getExpridedDate() {
        return expridedDate;
    }

    public void setExpridedDate(Date expridedDate) {
        this.expridedDate = expridedDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
