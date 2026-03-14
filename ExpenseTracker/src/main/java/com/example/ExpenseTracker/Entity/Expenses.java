package com.example.ExpenseTracker.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Table(name="smtb_tracker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {
@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

private long id;
        private LocalDate date;
        private int expense  ;
        private String category;
        private String loginUser;
        private int budget;
    }


