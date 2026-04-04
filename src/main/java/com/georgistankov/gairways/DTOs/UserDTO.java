package com.georgistankov.gairways.DTOs;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class UserDTO {

    @NotBlank(message = "No Username provided")
    @Size(min = 3, max = 20, message = "The size must be between 3 and 20 letters")
    private String Username;

    @NotBlank(message = "No password provided")
    @Size(min = 8, max = 20, message = "The size must be between 3 and 20 letters")
    private String Password;

    @NotBlank(message = "No email provided")
    @Size(min = 2, max = 35, message = "The size must be between 2 and 35 letters")
    private String Email;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
