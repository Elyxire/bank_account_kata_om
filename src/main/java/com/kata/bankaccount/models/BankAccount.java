package com.kata.bankaccount.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BankAccount {
    private double currentBalance;          //for the sake of simplicity I used double instead of BigDecimal
    private List<Transaction> transactions;

    public BankAccount() {
        currentBalance = 0.0;
        transactions = new ArrayList<>();
    }
}
