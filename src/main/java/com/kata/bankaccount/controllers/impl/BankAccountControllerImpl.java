package com.kata.bankaccount.controllers.impl;

import com.kata.bankaccount.controllers.BankAccountController;
import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BankAccountControllerImpl implements BankAccountController {
    private final BankAccountService bankAccountService;

    @Override
    public ResponseEntity<TransactionView> depositMoney(TransactionDto transactionDto) {
        TransactionView transactionView = bankAccountService.depositMoney(transactionDto);
        return ResponseEntity.ok(transactionView);
    }
}
