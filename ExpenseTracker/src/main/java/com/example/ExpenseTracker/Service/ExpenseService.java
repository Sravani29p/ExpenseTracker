package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.Entity.Expenses;
import com.example.ExpenseTracker.MyRepository.MyRepositoryExpenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    MyRepositoryExpenses myRepositoryExpenses;;
    public List<Expenses> getAllExpenses(){

        return myRepositoryExpenses.findAll();
    }
}
