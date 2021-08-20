package br.com.devbyjoaos.pagseguro.bank.account.service;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import br.com.devbyjoaos.pagseguro.bank.account.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
class BankAccountServiceTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountService bankAccountService;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mustNotFindAnAccount(){
        when(this.bankAccountRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> this.bankAccountService.findbankAccountById(1l));
    }

    @Test
    public void mustReturnAnAccount(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(1L);
        when(this.bankAccountRepository.findById(anyLong())).thenReturn(Optional.of(bankAccount));

        BankAccount accountFound = this.bankAccountService.findbankAccountById(1l);
        assertEquals(accountFound.getId(), 1l);
    }

    @Test
    public void mustNotFindAnAccountByAccountNumber(){
        when(bankAccountRepository.findByAccountNumber(anyLong())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> this.bankAccountService.findbankAccountByAccountNumber(1l));
    }

    @Test
    public void mustReturnAnAccountByAccountNumber(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(1L);
        when(this.bankAccountRepository.findByAccountNumber(anyLong())).thenReturn(Optional.of(bankAccount));

        BankAccount accountFound = this.bankAccountService.findbankAccountByAccountNumber(1l);
        assertEquals(accountFound.getId(), 1l);
    }

}