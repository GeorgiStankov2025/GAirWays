package com.georgistankov.gairways.Services;

import com.georgistankov.gairways.DTOs.UserDTO;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.UserRepository;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class UserService {

    private final UserRepository UserRepository;
    private Argon2PasswordEncoder PasswordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    public UserService(UserRepository userRepository,Argon2PasswordEncoder passwordEncoder) {
        this.UserRepository = userRepository;
        this.PasswordEncoder = passwordEncoder;
    }

    public User getUser(UUID UserId){
        return UserRepository.findById(UserId).get();
    }

    public User Register(UserDTO request){

        User user=new User();



        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        return UserRepository.save(user);

    }

}
