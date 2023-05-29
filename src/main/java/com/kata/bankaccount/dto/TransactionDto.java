package com.kata.bankaccount.dto;

import com.kata.bankaccount.models.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private static final long serialVersionUID = 1L;

    private double amount;
    private TransactionType type;
}
