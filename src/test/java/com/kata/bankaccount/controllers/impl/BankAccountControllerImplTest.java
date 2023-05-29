package com.kata.bankaccount.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.bankaccount.BankAccountApplication;
import com.kata.bankaccount.dto.TransactionDto;
import com.kata.bankaccount.models.enums.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.kata.bankaccount.utils.Constants.INVALID_AMOUNT_DEPOSIT_OPERATION;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BankAccountApplication.class)
@AutoConfigureMockMvc
public class BankAccountControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositMoney_WhenAmountIsNegative_ShouldThrowError_Test() throws Exception {
        TransactionDto transactionDto = TransactionDto.builder()
                .amount(-100)
                .type(TransactionType.DEPOSIT).build();
        mockMvc.perform(post("/api/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionDto)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertEquals(INVALID_AMOUNT_DEPOSIT_OPERATION, result.getResolvedException().getMessage()));
    }

    @Test
    public void depositMoneyTest_WhenAmountIsPositive_ShouldAddAmountToAccountBalance_Test() throws Exception {
        TransactionDto transactionDto = TransactionDto.builder()
                .amount(100)
                .type(TransactionType.DEPOSIT).build();
        TransactionDto expectedResult = TransactionDto.builder()
                .amount(100)
                .type(TransactionType.DEPOSIT).build();

        mockMvc.perform(post("/api/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type", is(TransactionType.DEPOSIT.toString())))
                .andExpect(jsonPath("$.amount", is(100.0)));
    }

}
