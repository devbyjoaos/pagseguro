package br.com.devbyjoaos.pagseguro.bank.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_bank_account_baac", schema="public")
public class BankAccount {

    @Id
    @GeneratedValue(generator = "sq_bank_account", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq_bank_account", allocationSize = 1)
    @Column(name = "id_bank_account", nullable = false)
    private Long id;

    @Column(name = "st_name", nullable = false)
    private String name;

    @Column(name = "nr_account_number", nullable = false)
    private Long accountNumber;

    @Column(name = "nr_agency", nullable = false)
    private Long agency;

    @Convert(converter = OverdraftEnum.OverdraftEnumConverter.class)
    @Column(name = "nr_overdraft", nullable = false)
    private OverdraftEnum overdraft;

    @Column(name = "db_balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "db_overdraft", nullable = false)
    private BigDecimal overdraftValue;

    @Column(name = "db_tax", nullable = false)
    private BigDecimal tax;
}
