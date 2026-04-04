package com.georgistankov.gairways.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Configuration;

@Configuration
class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new Argon2PasswordEncoder(16, 32, 1, 15 * 1024, 2);
    }

}
