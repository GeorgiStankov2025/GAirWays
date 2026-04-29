package com.georgistankov.gairways.Controllers.v1;

import com.georgistankov.gairways.DTOs.LoginUserDTO;
import com.georgistankov.gairways.DTOs.UserDTO;
import com.georgistankov.gairways.Exceptions.BadRequestException;
import com.georgistankov.gairways.Models.User;
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
                          PasswordEncoder encoder,
                          JwtUtil jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginUserDTO user) throws BadRequestException{

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails == null)
        {
         throw new BadRequestException("Invalid username or password");
        }
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

    @GetMapping("/me")
    public String getCurrentUserUsername()
    {

        return userService.getCurrentUserUsername();

    }

}