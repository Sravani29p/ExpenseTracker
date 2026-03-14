package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.Entity.Expenses;
import com.example.ExpenseTracker.Entity.loginUser;
import com.example.ExpenseTracker.MyRepository.MyRepositoryExpenses;
import com.example.ExpenseTracker.MyRepository.MyRepositoryloginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {


    @Autowired
    MyRepositoryloginUser  myRepositoryloginUser;
    public List<loginUser> getAllUsers(){


        return  myRepositoryloginUser.findAll();
    }
}
