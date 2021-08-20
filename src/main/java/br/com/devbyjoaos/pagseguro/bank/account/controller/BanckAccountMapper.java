package br.com.devbyjoaos.pagseguro.bank.account.controller;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccountFilter;
import br.com.devbyjoaos.pagseguro.bank.account.model.OverdraftEnum;
import br.com.devbyjoaos.pagseguro.bank.account.utils.Numbers;

import java.math.BigDecimal;

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
                .overdraft(bankAccount.getOverdraft().getName())
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
                .overdraft(OverdraftEnum.fromId(filterDto.getOverdraft()))
                .build();
    }

    public static DetailAccountDto bankAccountToDetailDto(BankAccount bankAccount){
        if(isNull(bankAccount))
            return new DetailAccountDto();

        BigDecimal multiplicand = new BigDecimal(1).add(bankAccount.getTax().divide(new BigDecimal(100)));

        return DetailAccountDto.builder()
                .name(bankAccount.getName())
                .agencyAndAccount(Numbers.formatAgencyAndAccount(bankAccount.getAgency(), bankAccount.getAccountNumber()))
                .balance(Numbers.formatMoney("R$ ", bankAccount.getBalance()))
                .overdraftSituation(bankAccount.getOverdraft().getName())
                .overdraftValue(Numbers.formatMoney("R$ ", bankAccount.getOverdraftValue().multiply(multiplicand)))
                .build();
    }
}
