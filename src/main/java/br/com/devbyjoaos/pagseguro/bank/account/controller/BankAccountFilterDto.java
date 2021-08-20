package br.com.devbyjoaos.pagseguro.bank.account.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountFilterDto {

    private String name;
    private Long agency;
    private Integer overDraft;

}
