package br.com.devbyjoaos.pagseguro.bank.account.controller;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import br.com.devbyjoaos.pagseguro.bank.account.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/conta")
@Controller
@RequiredArgsConstructor
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public BankAccountDto createNewBankAccount(@RequestBody BankAccount bankAccount){
        BankAccount bankAccountCreated = bankAccountService.createBankAccount(bankAccount);
        return BanckAccountMapper.entityToDto(bankAccountCreated);
    }

    @GetMapping
    public List<BankAccountDto> getBankAccounts(){
        List<BankAccount> bankAccountList = bankAccountService.findAllAccounts();
        return bankAccountList.stream().map(BanckAccountMapper::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BankAccountDto getBankAccountById(@PathVariable Long id){
        BankAccount bankAccount = bankAccountService.findbankAccountById(id);
        return BanckAccountMapper.entityToDto(bankAccount);
    }

    @PutMapping
    public BankAccountDto updateBankAccount(@RequestBody BankAccount bankAccount){
        BankAccount bankAccountUpdated = bankAccountService.updateBankAccount(bankAccount);
        return BanckAccountMapper.entityToDto(bankAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Long id){
        bankAccountService.deleteBankAccountById(id);
    }

    @PostMapping("/filtrar")
    public List<BankAccountDto> findBankAccountsByFilter(@RequestBody BankAccountFilterDto filterDto){
        List<BankAccount> accountsList = bankAccountService.findBankAccountsWithFilter(
                                                BanckAccountMapper.bankAccountFilterDtoToEntity(filterDto));

        return accountsList.stream().map(BanckAccountMapper::entityToDto).collect(Collectors.toList());
    }
}
