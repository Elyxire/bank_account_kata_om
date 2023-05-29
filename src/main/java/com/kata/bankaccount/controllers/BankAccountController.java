package com.kata.bankaccount.controllers;

import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public interface BankAccountController {
    @PostMapping("/deposit")
    ResponseEntity<TransactionView> depositMoney(@RequestBody TransactionDto transactionDto);

    @PostMapping("/withdraw")
    ResponseEntity<TransactionView> withdrawMoney(@RequestBody TransactionDto transactionDto);

    @GetMapping("/history")
    ResponseEntity<List<TransactionView>> getHistoryOperations();
}
