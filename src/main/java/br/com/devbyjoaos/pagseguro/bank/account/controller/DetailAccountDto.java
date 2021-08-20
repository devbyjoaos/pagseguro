package br.com.devbyjoaos.pagseguro.bank.account.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailAccountDto {
    private String name;
    private String agencyAndAccount;
    private String balance;
    private String overdraftSituation;
    private String overdraftValue;
}
