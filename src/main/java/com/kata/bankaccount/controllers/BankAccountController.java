package com.kata.bankaccount.controllers;

import com.kata.bankaccount.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public interface BankAccountController {
    @PostMapping("/deposit")
    ResponseEntity<TransactionDto> depositMoney(@RequestBody TransactionDto transactionDto);
}
