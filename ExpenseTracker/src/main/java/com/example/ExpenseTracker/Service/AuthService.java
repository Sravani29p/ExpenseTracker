package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.Entity.loginUser;
import com.example.ExpenseTracker.MyRepository.MyRepositoryloginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private MyRepositoryloginUser myRepositoryloginUser;
    public boolean authenticate(String username,String password){
         Optional<loginUser> userid=myRepositoryloginUser.findByuserId(username);
         if(userid.isPresent()){
             loginUser loginuser=userid.get();
             return password.equals(loginuser.getPassword());
         }
         return false;
    }
}
