package com.georgistankov.gairways.Repositories;

import com.georgistankov.gairways.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String Username);
    boolean existsByUsername(String Username);

}
