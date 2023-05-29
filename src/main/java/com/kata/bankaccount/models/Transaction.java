package com.kata.bankaccount.models;

import com.kata.bankaccount.models.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private double amount;
    private double balance;
    private TransactionType type;
    private LocalDateTime date;
}
