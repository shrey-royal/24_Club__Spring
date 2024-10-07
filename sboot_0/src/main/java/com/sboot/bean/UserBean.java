package com.sboot.bean;

import jakarta.validation.constraints.NotBlank;

public class UserBean {
    private Integer userId;

    @NotBlank(message = "Please enter FirstName")
    private String firstName;

    @NotBlank(message = "Please enter Email")
    private String email;

    @NotBlank
    private String password;

    Integer deleted;

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
