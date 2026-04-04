package com.georgistankov.gairways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GAirWaysApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(GAirWaysApplication.class, args);
    }
    @Bean
    public Argon2PasswordEncoder Argon2PasswordEncoder(PasswordEncoder passwordEncoder) {

        return new Argon2PasswordEncoder(16,32,4,32000,3);

    }

}
