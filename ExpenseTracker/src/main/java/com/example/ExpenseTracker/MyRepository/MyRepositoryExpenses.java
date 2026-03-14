package com.example.ExpenseTracker.MyRepository;

import com.example.ExpenseTracker.Entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyRepositoryExpenses extends JpaRepository<Expenses,Long> {

}
