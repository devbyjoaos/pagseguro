package br.com.devbyjoaos.pagseguro.bank.account.service;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccountFilter;
import br.com.devbyjoaos.pagseguro.bank.account.repository.BankAccountEspecifications;
import br.com.devbyjoaos.pagseguro.bank.account.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> findAllAccounts() {
        return this.bankAccountRepository.findAll();
    }

    public BankAccount findbankAccountById(Long id) {
        BankAccount bankAccount =  this.bankAccountRepository.findById(id).orElse(null);

        if(Objects.isNull(bankAccount))
            throw new IllegalArgumentException("Não foi possível encontrar uma conta com esse Id");

        return bankAccount;
    }

    public BankAccount updateBankAccount(BankAccount bankAccount) {
        findbankAccountById(bankAccount.getId()); //Caso não encontre conta com o  id passado ira lançar exception.
        return this.bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccountById(Long id) {
        findbankAccountById(id); //Caso não encontre conta com o  id passado ira lançar exception.
        this.bankAccountRepository.deleteById(id);
    }

    public List<BankAccount> findBankAccountsWithFilter(BankAccountFilter filter) {
        return this.bankAccountRepository.findAll(BankAccountEspecifications.equalAgency(filter.getAgency())
                .and(BankAccountEspecifications.equalOverdraft(filter.getOverdraft()))
                .and(BankAccountEspecifications.likeName(filter.getName())));
    }

    public BankAccount findbankAccountByAccountNumber(Long accountNumber) {
        BankAccount bankAccount =  this.bankAccountRepository.findByAccountNumber(accountNumber).orElse(null);

        if(Objects.isNull(bankAccount))
            throw new IllegalArgumentException("Não foi possível encontrar uma conta com esse número");

        return bankAccount;
    }
}
