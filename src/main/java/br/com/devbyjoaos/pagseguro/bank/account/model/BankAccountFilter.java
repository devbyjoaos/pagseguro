package br.com.devbyjoaos.pagseguro.bank.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountFilter {

    private String name;
    private Long agency;
    private Integer overDraft;

}
