package com.kata.bankaccount.controllers.impl;

import com.kata.bankaccount.controllers.BankAccountController;
import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankAccountControllerImpl implements BankAccountController {
    private final BankAccountService bankAccountService;

    @Override
    public ResponseEntity<TransactionView> depositMoney(TransactionDto transactionDto) {
        TransactionView transactionView = bankAccountService.depositMoney(transactionDto);
        return ResponseEntity.ok(transactionView);
    }

    @Override
    public ResponseEntity<TransactionView> withdrawMoney(TransactionDto transactionDto) {
        TransactionView transactionView = bankAccountService.withdrawMoney(transactionDto);
        return ResponseEntity.ok(transactionView);
    }

    @Override
    public ResponseEntity<List<TransactionView>> getHistoryOperations(String type, String startDate, String endDate) {
        List<TransactionView> transactionViews = bankAccountService.getHistoryOperations(type, startDate, endDate);
        return ResponseEntity.ok(transactionViews);
    }
}
