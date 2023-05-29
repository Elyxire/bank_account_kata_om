package com.kata.bankaccount.controllers.views;

import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.models.Transaction;
import com.kata.bankaccount.models.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class TransactionView {
    private double amount;
    private double balance;
    private TransactionType type;
    private LocalDateTime date;

    public static TransactionView fromTransactionDTO(TransactionDto transactionDto) {
        return TransactionView.builder()
                .type(transactionDto.getType())
                .amount(transactionDto.getAmount())
                .build();
    }

    public static TransactionView fromTransaction(Transaction transaction) {
        return TransactionView.builder()
                .type(transaction.getType())
                .amount(transaction.getAmount())
                .balance(transaction.getBalance())
                .date(transaction.getDate())
                .build();
    }

    public static List<TransactionView> fromTransactionDTOList(List<Transaction> transactions) {
        return transactions.stream().map(TransactionView::fromTransaction).collect(Collectors.toList());
    }
}