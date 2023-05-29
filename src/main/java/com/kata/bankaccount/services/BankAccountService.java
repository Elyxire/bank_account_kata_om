package com.kata.bankaccount.services;

import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;

public interface BankAccountService {
    TransactionView depositMoney(TransactionDto transactionDto);
}
