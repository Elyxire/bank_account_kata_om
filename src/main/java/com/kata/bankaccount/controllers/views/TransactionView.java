package com.kata.bankaccount.controllers.views;

import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.models.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TransactionView {
    private double amount;
    private TransactionType type;

    public static TransactionView fromTransactionDTO(TransactionDto transactionDto) {
        return TransactionView.builder()
                .type(transactionDto.getType())
                .amount(transactionDto.getAmount())
                .build();
    }
}
