# Experiment 07: Student Record Management System

**Status:** ✅ Completed

## 📝 Description
A comprehensive file-based student record management system demonstrating **File I/O operations**, **CRUD operations**, and **Exception Handling** in Java using CSV format.

## ✨ Features
* **CSV File Management:** Students.csv stores student records
* **CRUD Operations:**
  - **Create:** Add 3 new student records with marks4 and marks5 initially set to 0
  - **Read:** Display all student records from CSV file
  - **Update:** Modify marks for specific students and recalculate percentage
  - **Delete:** Remove student records from the file
* **GPA/Percentage Calculation:** Automatic calculation based on 5 subject marks (formula: (total/500)*100)
* **Exception Handling:** IOException handling for all file operations
* **Modular Design:** Separate classes for each CRUD operation

## 📋 Student Data Structure
```
studentId, name, branch, marks1, marks2, marks3, marks4, marks5, percentage
```

### Example:
- **Initial Data (2 rows):** Pre-existing student records with complete marks
- **Created Data (3 rows):** New students added with marks4 and marks5 = 0 initially
- **Percentage Column:** Automatically calculated for each student

## 🚀 How to Run
```bash
javac Student.java StudentCreate.java StudentRead.java StudentUpdate.java StudentDelete.java StudentDisplay.java Main.java
java Main
```

## 📂 Files
- `Student.java` - Student model class with percentage calculation
- `StudentCreate.java` - CREATE operation to add new student records
- `StudentRead.java` - READ operation to display student records
- `StudentUpdate.java` - UPDATE operation to modify marks and recalculate percentage
- `StudentDelete.java` - DELETE operation to remove student records
- `StudentDisplay.java` - DISPLAY wrapper for showing records
- `Students.csv` - CSV data file with student records
- `Main.java` - Menu-driven driver with switch-case interface
- `README.md` - This file

## 🎯 Key Concepts
- **IOException Handling:** Try-catch blocks for file I/O operations
- **File Reading:** BufferedReader to read CSV data
- **File Writing:** FileWriter and BufferedWriter to modify CSV file
- **Data Processing:** Parsing CSV lines and updating records
- **ArrayList Usage:** Storing records for manipulation before writing back
- **Percentage Calculation:** Formula: (sum of marks / 500) * 100

## 💡 Learning Outcomes
- Master file I/O operations (reading and writing)
- Implement CRUD operations on file-based storage
- Handle IOExceptions appropriately
- Parse and manipulate CSV data
- Design modular solutions for file management
- Create menu-driven applications with proper error handling

## 📋 Menu Options
1. **Create** - Add 3 new students (marks4 & marks5 = 0 initially)
2. **Read** - Display all student records with header
3. **Update** - Update marks for a specific student and recalculate percentage
4. **Delete** - Remove a student record by ID
5. **Exit** - Display final records and terminate

## 🛡️ Exception Handling
All file operations are wrapped in try-catch blocks to handle:
- File not found exceptions
- IOException during read/write operations
- Output displays exception message if operation fails

## 📊 Percentage Calculation Logic
```
Total Marks = marks1 + marks2 + marks3 + marks4 + marks5
Percentage = (Total Marks / 500) * 100
```
Example: If total = 433, then percentage = 86.60%
