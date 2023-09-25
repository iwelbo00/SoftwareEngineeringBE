package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.userDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userDetails, Long> {
    userDetails findByUsernameAndPasswordHash(String username, String password);
    userDetails findByUsername(String username);
}