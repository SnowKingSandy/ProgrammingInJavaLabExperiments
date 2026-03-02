# Experiment 03: Book Management System

**Status:** ✅ Completed

## 📝 Description
An Object-Oriented program to manage a library of books. It demonstrates **Custom Exception Handling**, **ArrayList operations**, and **Encapsulation**.

## ✨ Features
* **Custom Exceptions:** InvalidPriceException and InvalidGenreException for input validation
* **3 Constructor Types:** Default, Parameterized (with exception throwing), and Copy constructors
* **ArrayList Operations:** Adding, retrieving, and iterating through book collections
* **Exception Handling:** Try-catch blocks to handle negative prices and invalid genres
* **Calculations:** Average price calculation for all books
* **Filtering:** Using forEach() method to print books of a specific genre (Fiction)

## 🚀 How to Run
```bash
javac Book.java InvalidPriceException.java InvalidGenreException.java ArrayListOfBooks.java
java ArrayListOfBooks
```

## 📂 Files
- `Book.java` - Book class with three constructors and display methods
- `ArrayListOfBooks.java` - Driver class with ArrayList management and exception handling
- `InvalidPriceException.java` - Custom exception for invalid prices
- `InvalidGenreException.java` - Custom exception for invalid genres
- `README.md` - This file

## 🎯 Key Concepts
- **Custom Exceptions:** Extending Exception class for domain-specific error handling
- **Encapsulation:** Public attributes with getter/setter patterns
- **ArrayList:** Dynamic collection management with add, contains, and forEach operations
- **Exception Propagation:** Throwing exceptions from constructors
- **Filtering:** Using lambda expressions in forEach to filter by genre
- **Calculations:** Computing average values from collection data

## 💡 Learning Outcomes
- Understand how to create and throw custom exceptions
- Master ArrayList operations and iteration methods
- Apply try-catch-finally blocks for exception handling
- Use lambda expressions for functional filtering
