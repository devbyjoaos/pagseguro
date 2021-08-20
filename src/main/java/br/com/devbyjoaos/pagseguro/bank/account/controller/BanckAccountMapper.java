package br.com.devbyjoaos.pagseguro.bank.account.controller;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccountFilter;

import static java.util.Objects.isNull;

public abstract class BanckAccountMapper {

    public static BankAccountDto entityToDto(BankAccount bankAccount){
        if(isNull(bankAccount))
            return null;

        return BankAccountDto.builder()
                .id(bankAccount.getId())
                .name(bankAccount.getName())
                .accountNumber(bankAccount.getAccountNumber())
                .agency(bankAccount.getAgency())
                .overdraft("Sim")
                .balance(bankAccount.getBalance())
                .overdraftValue(bankAccount.getOverdraftValue())
                .tax(bankAccount.getTax())
                .build();
    }

    public static BankAccountFilter bankAccountFilterDtoToEntity(BankAccountFilterDto filterDto){
        if(isNull(filterDto))
            return new BankAccountFilter();

        return BankAccountFilter.builder()
                .name(filterDto.getName())
                .agency(filterDto.getAgency())
                .overDraft(isNull(filterDto.getOverDraft())? null: filterDto.getOverDraft())
                .build();
    }
}
