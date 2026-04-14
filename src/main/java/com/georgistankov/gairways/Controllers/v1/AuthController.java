package com.georgistankov.gairways.Controllers.v1;

import com.georgistankov.gairways.DTOs.LoginUserDTO;
import com.georgistankov.gairways.DTOs.UserDTO;
import com.georgistankov.gairways.Models.User;
import com.georgistankov.gairways.Repositories.UserRepository;
import com.georgistankov.gairways.Security.JwtUtil;
import com.georgistankov.gairways.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtils;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          UserRepository userRepository,
                          PasswordEncoder encoder,
                          JwtUtil jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginUserDTO user) {

        String passwordHash=encoder.encode(user.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody UserDTO user)
    {

        return userService.register(user);

    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getAllUsers();
    }

}