package com.kata.bankaccount.services.impl;

import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.exceptions.BadArgumentsException;
import com.kata.bankaccount.models.BankAccount;
import com.kata.bankaccount.models.Transaction;
import com.kata.bankaccount.models.enums.TransactionType;
import com.kata.bankaccount.services.BankAccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.kata.bankaccount.controllers.views.TransactionView.fromTransactionDTOList;
import static com.kata.bankaccount.utils.Constants.INVALID_AMOUNT_DEPOSIT_OPERATION;
import static com.kata.bankaccount.utils.Constants.INVALID_AMOUNT_WITHDRAW_OPERATION;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccount bankAccount;

    public BankAccountServiceImpl() {
        bankAccount = new BankAccount();
    }

    @Override
    public TransactionView depositMoney(TransactionDto transactionDto) {
        if(transactionDto.getAmount() < 0) {
            throw new BadArgumentsException(INVALID_AMOUNT_DEPOSIT_OPERATION);
        }
        bankAccount.setCurrentBalance(bankAccount.getCurrentBalance() + transactionDto.getAmount());
        List<Transaction> transactions = bankAccount.getTransactions();
        transactions.add(Transaction.builder()
                .amount(transactionDto.getAmount())
                .type(TransactionType.DEPOSIT)
                .balance(bankAccount.getCurrentBalance())
                .date(LocalDateTime.now()).build());
        bankAccount.setTransactions(transactions);
        return TransactionView.fromTransactionDTO(transactionDto);
    }

    @Override
    public TransactionView withdrawMoney(TransactionDto transactionDto) {
        if(transactionDto.getAmount() < 0 || transactionDto.getAmount() > bankAccount.getCurrentBalance()) {
            throw new BadArgumentsException(INVALID_AMOUNT_WITHDRAW_OPERATION);
        }
        bankAccount.setCurrentBalance(bankAccount.getCurrentBalance() - transactionDto.getAmount());
        List<Transaction> transactions = bankAccount.getTransactions();
        transactions.add(Transaction.builder()
                .amount(transactionDto.getAmount())
                .type(TransactionType.WITHDRAWAL)
                .balance(bankAccount.getCurrentBalance())
                .date(LocalDateTime.now()).build());
        bankAccount.setTransactions(transactions);
        return TransactionView.fromTransactionDTO(transactionDto);
    }

    @Override
    public List<TransactionView> getHistoryOperations(String type, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fromTransactionDTOList(bankAccount.getTransactions()
                .stream()
                .filter(t -> type == null || t.getType().toString().equals(type))
                .filter(t -> startDate == null || t.getDate().isAfter(LocalDateTime.parse(startDate, formatter)))
                .filter(t -> endDate == null || t.getDate().isBefore(LocalDateTime.parse(endDate, formatter)))
                .collect(Collectors.toList()));
    }
}
