# 🏦 Experiment 05: Banking Application

**Status:** ✅ Completed

## 📝 Description

A comprehensive menu-driven banking application demonstrating OOP principles including inheritance, polymorphism, abstraction, and encapsulation. This application models a real-world banking system with multiple account types and transaction management.

## ✨ Features

- **Multiple Account Types:**
  - Savings Account (4% annual interest, Rs. 1000 minimum balance)
  - Current Account (25% overdraft facility, cheque book support)
  - Loan Account (EMI calculation, multiple loan types)
  - Fixed Deposit (Simple interest, maturity tracking)

- **Customer Management:**
  - Create new customers with profiles
  - Manage multiple accounts per customer
  - View consolidated customer information
  - Track total balance across accounts

- **Transaction Operations:**
  - Deposit money with validation
  - Withdraw with account-specific rules
  - Pay EMI for loans
  - Calculate and credit interest
  - View complete transaction history

- **Advanced Features:**
  - EMI calculation using compound interest formula
  - Account-specific constraints and validations
  - Transaction tracking with timestamps
  - Overdraft management for current accounts
  - Maturity date tracking for FD accounts

## 🏗️ Architecture

```
Account (Abstract)
├── SavingsAccount
├── CurrentAccount
├── LoanAccount
└── FDAccount

Customer
├── List<Account> accounts
└── Methods for account management

Transaction
├── Transaction ID, Amount, Type
└── DateTime, Description

BankingApplication
└── Menu-driven main application
```

## 🚀 How to run

```bash
javac *.java
java BankingApplication
```

## 📋 Usage Example

1. **Create a Customer:** Enter name, email, phone
2. **Create Accounts:** Choose account type and initial amount
3. **Perform Transactions:** Deposit, withdraw, pay EMI, calculate interest
4. **View Details:** Check account balances, transaction history, consolidated info

## 🎓 Key Concepts Demonstrated

- **Inheritance:** Base `Account` class extended by 4 account types
- **Polymorphism:** Different `deposit()` and `withdraw()` implementations
- **Abstraction:** Abstract methods in base class
- **Encapsulation:** Proper use of private/protected fields
- **Exception Handling:** `IllegalArgumentException` for validation
- **Collections:** `ArrayList` for managing accounts and transactions
- **Design Patterns:** Menu-driven application pattern

## 💾 Technical Details

- **Language:** Java (JDK 17+)
- **Paradigm:** Object-Oriented Programming
- **Build:** Standard `javac` compiler
- **Dependencies:** None (pure Java)

## 📊 Account Rules

**Savings Account:**
- Minimum balance: Rs. 1000
- Interest rate: 4% per annum
- Interest credit: Annual

**Current Account:**
- No minimum balance
- Overdraft limit: 25% of initial balance
- Cheque book fee: Rs. 100

**Loan Account:**
- EMI calculation: `P * [r(1+r)^n] / [(1+r)^n - 1]`
- Monthly interest compounding
- Types: Personal, Home, Auto, Education

**Fixed Deposit Account:**
- Minimum: Rs. 5000
- Simple interest: `A = P * (1 + (r * t / 100))`
- Maturity tracking with days remaining

## 👨‍💻 Development Notes

This project evolved through multiple commits:
1. Core structure with Account and SavingsAccount
2. Customer management and basic application
3. Advanced account types (Current, Loan, FD)
4. Full application functionality
5. Code refinement and quality improvements
6. Documentation and finalization

---

**Maintained by:** SnowKingSandy  
**Course:** Programming Logic with Java (Semester IV)
