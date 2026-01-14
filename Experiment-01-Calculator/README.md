# Experiment 01: Calculator (Phase 2 - Full Logic / Unsafe)

**Status:** ⚠️ Functional but Unsafe (No Exception Handling)

## 📝 Description
Version 2 completes the arithmetic logic. The application can now perform Addition, Subtraction, Multiplication, Division, and Modulo. 

**Note:** This version does **not** handle runtime errors. Dividing by zero may result in `Infinity` or program crashes.

## ✅ Implemented Features
* **All Math Operations:** Methods added for `multiplyNums`, `divideNums`, and `calcMod`.
* **Full Menu Integration:** The switch statement now handles all 5 cases.

## ⚠️ Known Issues
* **Division by Zero:** There is no check if the second number is 0. 
* **Input Validation:** Non-integer inputs inside the number prompt will still crash the program.

## 🔜 Coming Next (Final Version)
* [ ] Add `try-catch` blocks to handle `ArithmeticException`.
* [ ] Add custom error messages for Division by Zero.

## 🚀 How to Run
```bash
javac Calculator.java
java Calculator