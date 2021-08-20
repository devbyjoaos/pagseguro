package br.com.devbyjoaos.pagseguro.bank.account.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {

    private Long id;

    private String name;

    private Long accountNumber;

    private Long agency;

    private String overdraft;

    private BigDecimal balance;

    private BigDecimal overdraftValue;

    private BigDecimal tax;
}
