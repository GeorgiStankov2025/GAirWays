package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.DTOs.UserDTO;
import com.georgistankov.gairways.Enums.UserRole;
import com.georgistankov.gairways.Models.Flight;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

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

    public User register(UserDTO request){


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
        userRepository.saveAndFlush(user);
        return user;

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswordHash(),
                Collections.emptyList()
        );
    }



}
