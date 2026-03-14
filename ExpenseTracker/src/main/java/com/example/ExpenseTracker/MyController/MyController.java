package com.example.ExpenseTracker.MyController;


import com.example.ExpenseTracker.Entity.Expenses;
import com.example.ExpenseTracker.Entity.loginUser;
import com.example.ExpenseTracker.MyRepository.MyRepositoryExpenses;
import com.example.ExpenseTracker.MyRepository.MyRepositoryloginUser;
import com.example.ExpenseTracker.Service.AuthService;
import com.example.ExpenseTracker.Service.ExpenseService;
import com.example.ExpenseTracker.Service.UpdateService;
import com.example.ExpenseTracker.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.springframework.web.bind.annotation.
@RestController

public class MyController {
    @Autowired
    MyRepositoryExpenses myRepositoryExpenses;

    @Autowired
    MyRepositoryloginUser myRepositoryloginUser;

    @Autowired
    AuthService authService;

    @Autowired
    ExpenseService  expenseService;

    @Autowired
    UpdateService updateService;
    @Autowired
    userService ue;

    @RequestMapping(method = RequestMethod.POST, path = "/addExpense")
    public ResponseEntity<String> createEntry(@RequestBody Expenses er) {
        boolean userExists = myRepositoryloginUser.existsById(er.getLoginUser());
        if (!userExists) {
            // User not registered, reject the request
            return ResponseEntity.badRequest().body("User '" + er.getLoginUser() + "' is not registered. Please register first.");
        }
        myRepositoryExpenses.save(er);
        return ResponseEntity.ok("success");
    }
    @RequestMapping(method = RequestMethod.GET, path = "/getExpense")
    public List<Expenses> getAllExpenses() {
        List<Expenses> l1=expenseService.getAllExpenses();
        return l1;
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteExpense")
    public void  deleteExpense(@RequestBody Long id) {
        myRepositoryExpenses.deleteById(id);
    }
    @RequestMapping(method = RequestMethod.PATCH, path = "/updateExpense")
    public ResponseEntity<Expenses> updateExpense(@RequestParam Long id, @RequestBody Expenses er) {
        Expenses expenses=updateService.updateValues(id,er);
        return ResponseEntity.ok(expenses);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registerUser")
    public String createUserEntry(@RequestBody loginUser ur) {
        myRepositoryloginUser.save(ur);
        return "success";

    }
    @RequestMapping(method = RequestMethod.POST, path = "/getAlluser")
    public List<loginUser> getAllUsers() {
        List<loginUser> u1= ue.getAllUsers();
        return u1;
    }
    @RequestMapping(method = RequestMethod.POST, path = "/loginUser")
    public String verifyUserEntry(@RequestBody loginUser ur) {
         boolean Authenticated = authService.authenticate(ur.getUserId(), ur.getPassword());
        if (Authenticated){
            return "user registered";
        }
        else{
            return "user not registered";
        }
    }
}
