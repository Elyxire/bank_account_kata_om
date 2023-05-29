package com.kata.bankaccount.controllers;

import com.kata.bankaccount.controllers.views.TransactionView;
import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.exceptions.BadArgumentsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = {"BankAccount - APIs"})
public interface BankAccountController {
    @PostMapping("/deposit")
    @ApiOperation(value = "Deposit money in bank account")
    @ApiResponses({@ApiResponse(code = 200, message = "Success", response = TransactionView.class),
            @ApiResponse(code = 400, message = "BadArgumentsException", response = BadArgumentsException.class)})
    ResponseEntity<TransactionView> depositMoney(@RequestBody TransactionDto transactionDto);

    @PostMapping("/withdraw")
    @ApiOperation(value = "Withdraw money from bank account")
    @ApiResponses({@ApiResponse(code = 200, message = "Success", response = TransactionView.class),
            @ApiResponse(code = 400, message = "BadArgumentsException", response = BadArgumentsException.class)})
    ResponseEntity<TransactionView> withdrawMoney(@RequestBody TransactionDto transactionDto);

    @GetMapping("/history")
    @ApiOperation(value = "Get bank account's operations history")
    @ApiResponses({@ApiResponse(code = 200, message = "Success", response = TransactionView.class, responseContainer = "List")})
    ResponseEntity<List<TransactionView>> getHistoryOperations(@RequestParam(required = false) String type, @RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate);
}
