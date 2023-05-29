package com.kata.bankaccount.services;

import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;

import java.util.List;

public interface BankAccountService {
    TransactionView depositMoney(TransactionDto transactionDto);
    TransactionView withdrawMoney(TransactionDto transactionDto);
    List<TransactionView> getHistoryOperations();
}
