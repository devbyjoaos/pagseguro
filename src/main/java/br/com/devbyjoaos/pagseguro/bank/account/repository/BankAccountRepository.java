package br.com.devbyjoaos.pagseguro.bank.account.repository;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
