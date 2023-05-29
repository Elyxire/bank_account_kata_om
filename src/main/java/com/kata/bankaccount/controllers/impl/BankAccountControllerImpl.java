package com.kata.bankaccount.controllers.impl;

import com.kata.bankaccount.controllers.BankAccountController;
import com.kata.bankaccount.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountControllerImpl implements BankAccountController {
    @Override
    public ResponseEntity<TransactionDto> depositMoney(TransactionDto transactionDto) {
        return null;
    }
}
