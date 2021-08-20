package br.com.devbyjoaos.pagseguro.bank.account.repository;

import br.com.devbyjoaos.pagseguro.bank.account.model.BankAccount;
import br.com.devbyjoaos.pagseguro.bank.account.model.OverdraftEnum;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

@SuppressWarnings("serial")
public class BankAccountEspecifications {

    public final static Specification<BankAccount> equalAgency(Long agency) {
        return new Specification<BankAccount>() {
            public Predicate toPredicate(Root<BankAccount> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (Objects.isNull(agency))
                    return null;
                return builder.equal(root.get("agency"), agency);
            }
        };
    }

    public final static Specification<BankAccount> equalOverdraft(OverdraftEnum overdraft) {
        return new Specification<BankAccount>() {
            public Predicate toPredicate(Root<BankAccount> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (Objects.isNull(overdraft))
                    return null;
                return builder.equal(root.get("overdraft"), overdraft);
            }
        };
    }

    public final static Specification<BankAccount> likeName(String name) {
        return new Specification<BankAccount>() {
            public Predicate toPredicate(Root<BankAccount> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (Objects.isNull(name))
                    return null;
                return builder.like(root.get("name"), '%' + name + '%');
            }
        };
    }

}
