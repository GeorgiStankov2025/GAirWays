package com.georgistankov.gairways.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUserDTO {

    @NotBlank(message = "No Username provided")
    @Size(min = 3, max = 20, message = "The size must be between 3 and 20 letters")
    private String Username;

    @NotBlank(message = "No password provided")
    @Size(min = 8, max = 20, message = "The size must be between 3 and 20 letters")
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
