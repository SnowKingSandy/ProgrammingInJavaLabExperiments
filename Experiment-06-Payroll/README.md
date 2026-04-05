# Experiment 06: Employee Payroll Management System

**Status:** ✅ Completed

## 📝 Description
A comprehensive employee payroll system demonstrating **Multilevel Inheritance** (Abstract → Concrete → Specialized) and **Polymorphism** in Java.

## ✨ Features
* **Multilevel Inheritance Hierarchy:**
  - Abstract `Employee` base class with common properties
  - `FullTimeEmployee` extending Employee with role-specific CTC calculation
  - `ContractEmployee` extending Employee for hourly workers
  - `Manager` extending FullTimeEmployee with additional allowances
* **Polymorphic CTC Calculation:** Different CTC formulas for each employee type
* **Menu-Driven System:** Interactive employee creation with Scanner input
* **ArrayList Management:** Store and retrieve multiple employee records
* **Role-Based Processing:** Different salary components for SWE, HR, and Manager roles

## 🎯 Employee Types & CTC Calculation

### 1. Software Engineer (SWE)
- CTC = Base Salary + Performance Bonus
- Full-time employee with performance incentives

### 2. HR Specialist
- CTC = Base Salary + Hiring Commission
- Full-time employee with recruitment bonuses

### 3. Contract Employee
- CTC = Hours Worked × Hourly Rate
- Flexible hourly-based compensation

### 4. Manager
- CTC = Base Salary + Performance Bonus + Travel Allowance + Education Allowance
- Extended benefits for management roles

## 🚀 How to Run
```bash
javac Employee.java FullTimeEmployee.java ContractEmployee.java Manager.java Main.java
java Main
```

## 📂 Files
- `Employee.java` - Abstract base class with common attributes and operations
- `FullTimeEmployee.java` - Extends Employee with role-specific CTC logic
- `ContractEmployee.java` - Extends Employee for hourly workers
- `Manager.java` - Extends FullTimeEmployee with additional allowances
- `Main.java` - Menu-driven application for employee management
- `README.md` - This file

## 🎯 Key Concepts
- **Abstract Classes:** Base Employee class enforces contract for all subclasses
- **Method Overriding:** Each employee type implements own calcCTC() logic
- **Multilevel Inheritance:** Manager extends FullTimeEmployee which extends Employee
- **Polymorphism:** ArrayList<Employee> can hold all subclass instances
- **Scanner Input:** Interactive menu-driven user input for data entry
- **ArrayList Operations:** Add, iterate, and display employee records

## 💡 Learning Outcomes
- Understand abstract classes and interfaces in inheritance
- Master multilevel inheritance chains
- Implement polymorphic method overriding
- Design role-specific business logic using inheritance
- Build menu-driven applications with ArrayList
- Practice proper OOP design patterns for payroll systems

## 📋 Menu Options
1. Add Software Engineer (SWE) - Base + Bonus
2. Add HR Specialist - Base + Commission
3. Add Contract Employee - Hours × Rate
4. Add Manager - Base + Bonus + TA + Education Allowance
5. View All Employees and Exit
