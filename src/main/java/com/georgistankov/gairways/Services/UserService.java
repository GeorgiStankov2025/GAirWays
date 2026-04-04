package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.DTOs.UserDTO;
import com.georgistankov.gairways.Enums.UserRole;
import com.georgistankov.gairways.Models.Flight;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(UUID UserId){
        return userRepository.findById(UserId).get();
    }

    public User register(@NotNull UserDTO request){


        User user=new User();

        String passwordHash=passwordEncoder.encode(request.getPassword());

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordHash);
        List<User> users=userRepository.findAll();
        if((long) users.size()==0)
            user.setUserRole(UserRole.Admin);
        else
            user.setUserRole(UserRole.Customer);
        user.setCreatedAt(LocalDateTime.now());
        user.setModifiedAt(LocalDateTime.now());
        return userRepository.saveAndFlush(user);

    }

    



}
