CREATE sequence sq_bank_account;

create table tb_bank_account_baac (
                             id_bank_account bigint NOT NULL,
                             st_name varchar(240) NOT NULL,
                             nr_account_number bigint NOT NULL,
                             nr_agency bigint NOT NULL,
                             nr_overdraft smallint NOT NULL,
                             db_balance NUMERIC(13,2),
                             db_overdraft NUMERIC(13,2),
                             db_tax NUMERIC(3,2),
                             CONSTRAINT  tb_bank_account_pk PRIMARY KEY (id_bank_account),
                             CONSTRAINT tb_bank_Account_uk UNIQUE(nr_account_number, nr_agency);
);