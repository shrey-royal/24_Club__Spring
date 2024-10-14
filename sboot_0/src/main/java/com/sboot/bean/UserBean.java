package com.sboot.bean;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserBean {
    private Integer userId;

    @NotBlank(message = "Please enter FirstName")
    private String firstName;

    @NotBlank(message = "Please enter Email")
    private String email;

    @NotBlank
    private String password;

    Integer deleted;

    private String profilePic;
}
