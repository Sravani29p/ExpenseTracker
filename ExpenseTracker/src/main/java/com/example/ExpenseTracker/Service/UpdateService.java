package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.Entity.Expenses;
import com.example.ExpenseTracker.MyRepository.MyRepositoryExpenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Service
public class UpdateService {
    @Autowired
    MyRepositoryExpenses myRepositoryExpenses;

    public Expenses updateValues(@RequestParam Long id, Expenses expenseDetails){
       Optional<Expenses> expenseId =myRepositoryExpenses.findById(id);
         Expenses  expenses =expenseId.get();
          expenses.setCategory(expenseDetails.getCategory());
        return myRepositoryExpenses.save(expenses);
    }
}
