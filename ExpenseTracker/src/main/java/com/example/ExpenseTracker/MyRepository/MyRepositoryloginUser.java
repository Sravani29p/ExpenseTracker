package com.example.ExpenseTracker.MyRepository;

import com.example.ExpenseTracker.Entity.loginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyRepositoryloginUser extends JpaRepository<loginUser,String> {
    Optional<loginUser>findByuserId(String Username);

}
