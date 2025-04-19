package com.tournex.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {
	
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String mobileNumber;
    
    @NotBlank
    private String password;

    @NotBlank
    private String type;
}
