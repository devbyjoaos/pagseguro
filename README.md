# pagseguro
Code challenge from PagSeguro

# Create
Post: http://localhost:8080/v1/conta
Add new account to the data base.
Account{
  "name": String,
  "accountNumber": Long,
  "agency": Long,
  "overdraft": Long,
  "balance": BigDecimal,
  "overdraftValue": BigDecimal,
  "tax": BigDecimal
}

# Read All
Get: http://localhost:8080/v1/conta
List all accounts.

# Read By Id
Get: http://localhost:8080/v1/conta/{id}
Find account by Id.

# Update
Post: http://localhost:8080/v1/conta
Update existing account.
AccountDto{
  "id": Long,
  "name": String,
  "accountNumber": Long,
  "agency": Long,
  "overdraft": Long,
  "balance": BigDecimal,
  "overdraftValue": BigDecimal,
  "tax": BigDecimal
}

# Delete
Delete: http://localhost:8080/v1/conta/{id}
Delete account by Id.

# Read by Filter
Delete: http://localhost:8080/v1/conta/filtrar
List accounts by filter.
BankAccountFilterDto{
  "name": String,
  "agency": Long,
  "overdraft": Long
}

# Detail by account number
Delete: http://localhost:8080/v1/conta/numero/{accountNumber}
Find account detail with formated fields by account number.
