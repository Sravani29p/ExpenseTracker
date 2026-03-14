package com.example.ExpenseTracker.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="smtb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class loginUser {
@Id
        String userId;
        String password;;



}
