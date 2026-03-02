# Experiment 04: Vector Management System

**Status:** ✅ Completed

## 📝 Description
An Object-Oriented program to perform vector operations. Demonstrates **Custom Exception Handling**, **Static Methods**, and **Dimensional Validation**.

## ✨ Features
* **Dimension Validation:** Constructor validates that vectors are 2D or 3D only
* **Custom Exceptions:** InvalidVectorSizeException and DimensionMismatchException for robust error handling
* **Vector Operations:** 
  - `add()` - Returns a new Vector (sum of two vectors)
  - `subtract()` - Returns a new Vector (difference of two vectors)
  - `dotProduct()` - Returns a scalar double value (dot product)
* **Dimension Checking:** Static method to verify vectors have matching dimensions
* **Display Method:** `print()` method for formatted vector output
* **Comprehensive Test Cases:** 13 different test scenarios covering all operations and edge cases

## 🚀 How to Run
```bash
javac Vector.java InvalidVectorSizeException.java DimensionMismatchException.java Main.java
java Main
```

## 📂 Files
- `Vector.java` - Vector class with operations and validation
- `Main.java` - Comprehensive test cases demonstrating all functionality
- `InvalidVectorSizeException.java` - Custom exception for invalid vector sizes
- `DimensionMismatchException.java` - Custom exception for dimension mismatches
- `README.md` - This file

## 🎯 Key Concepts
- **Static Methods:** Vector operations implemented as static methods
- **Exception Handling:** Custom exceptions for domain-specific error handling
- **Dimensional Analysis:** Checking and validating vector dimensions
- **Vector Mathematics:** Add, subtract, and dot product operations
- **Edge Cases:** Zero vectors, negative values, and dimension mismatches

## 🧪 Test Cases Covered
1. Valid 2D vector addition
2. Valid 2D vector subtraction
3. Valid 3D vector dot product (different vectors)
4. Valid 3D vector self dot product (magnitude squared)
5. Invalid vector size exception (4D vector)
6. Invalid vector size exception (1D vector)
7. Dimension mismatch - addition (2D + 3D)
8. Dimension mismatch - subtraction (2D - 3D)
9. Dimension mismatch - dot product (2D · 3D)
10. Valid 3D vector addition
11. Valid 3D vector subtraction
12. Vectors with negative values (addition and dot product)
13. Zero vectors (addition and dot product with zero)

## 💡 Learning Outcomes
- Master custom exception creation and usage
- Understand vector mathematics operations
- Implement static methods for mathematical operations
- Design robust validation mechanisms
- Create comprehensive test coverage for edge cases
