# Experiment 08: Inventory Management System with Design Patterns

## Objective
This experiment demonstrates three essential design patterns in Java:
- **Singleton Pattern**: Ensures a single instance of InventoryManager
- **Adapter Pattern**: Adapts legacy LegacyItem class to the Product interface
- **Iterator Pattern**: Traverses through the inventory collection

## Key Concepts Covered
- **Singleton Pattern**: Private constructor, static getInstance() method
- **Adapter Pattern**: Wrapping incompatible interfaces to make them compatible
- **Iterator Pattern**: Sequential access to collection elements
- **Polymorphism**: Multiple product types implementing same interface
- **Collections**: ArrayList and Iterator usage

## Class Structure

### 1. **Product Interface**
Defines the contract that all products must follow:
```java
public interface Product {
    void displayDetails();
}
```

### 2. **LegacyItem Class**
Represents legacy products with incompatible interface:
- Attributes: `itemId`, `description`
- Method: `print()` - displays item details

### 3. **ProductAdapter Class**
Adapter implementing Product interface:
- Wraps a `LegacyItem` object
- `displayDetails()` method calls wrapped `LegacyItem.print()`
- Converts incompatible interface to Product interface

### 4. **NewProduct Class**
Modern product implementation:
- Implements Product interface
- Attribute: `name`
- `displayDetails()` prints product name

### 5. **InventoryManager Class (Singleton)**
Manages the product inventory:
```java
private static InventoryManager instance;
private List<Product> inventory;

public static InventoryManager getInstance()  // Returns single instance
public void addProduct(Product product)        // Adds products
public Iterator<Product> returnInventory()     // Returns iterator
public int getInventorySize()                  // Returns inventory size
```

### 6. **Main Class**
Demonstrates the complete functionality:
- Gets singleton InventoryManager instance
- Adds NewProduct and adapted LegacyItem products
- Iterates and displays all products

## Running the Application

```bash
javac *.java
java Main
```

## Expected Output

```
========== Inventory Management System ==========
Design Patterns: Singleton, Adapter, Iterator

--- Adding Products to Inventory ---

Total products in inventory: 6

--- Inventory Details ---

1. New Product: Laptop
2. New Product: Mouse
3. New Product: Keyboard
4. Legacy Item ID: LEG001 | Description: Original Monitor
5. Legacy Item ID: LEG002 | Description: USB Hub
6. Legacy Item ID: LEG003 | Description: Network Cable

========== End of Inventory ==========
```

## Design Pattern Benefits

### Singleton Pattern
- ✅ Ensures only one InventoryManager instance exists
- ✅ Provides global access point to inventory
- ✅ Prevents multiple inventory instances

### Adapter Pattern
- ✅ Makes LegacyItem compatible with Product interface
- ✅ Allows mixing old and new code without modification
- ✅ Promotes code reuse

### Iterator Pattern
- ✅ Provides uniform way to traverse inventory
- ✅ Hides collection internal structure
- ✅ Supports multiple simultaneous iterations

## Test Cases

The experiment includes 5 comprehensive test cases demonstrating each design pattern:

### 1. **TestSingleton.java**
Tests the Singleton pattern:
- Creates two InventoryManager instances
- Verifies they have the same reference (hash code)
- Confirms shared state across references
```bash
java TestSingleton
```
**Output:** Shows identical memory references and shared data

### 2. **TestAdapter.java**
Tests the Adapter pattern:
- Creates a LegacyItem directly
- Wraps it with ProductAdapter
- Compares output from both interfaces
```bash
java TestAdapter
```
**Output:** Both direct and adapted methods produce identical output

### 3. **TestIterator.java**
Tests the Iterator pattern:
- Adds 3 products to inventory (mixed types)
- Uses Iterator to traverse the collection
- Displays each product sequentially
```bash
java TestIterator
```
**Output:** Shows all 3 products traversed in order

### 4. **TestMixed.java**
Tests polymorphic handling:
- Creates 5 products (mix of NewProduct and adapted LegacyItems)
- Stores in ArrayList as Product interface type
- Polymorphically displays all products
```bash
java TestMixed
```
**Output:** Shows all 5 products handled correctly

### 5. **TestPolymorphism.java**
Tests interface polymorphism:
- Creates ArrayList of Product types
- Adds NewProduct and ProductAdapter instances
- Demonstrates runtime polymorphic behavior
```bash
java TestPolymorphism
```
**Output:** Shows type information and details for each product

### Running All Tests
```bash
javac *.java
java TestSingleton
java TestAdapter
java TestIterator
java TestMixed
java TestPolymorphism
```

## Learning Outcomes
- ✅ Understanding Singleton pattern implementation
- ✅ Using Adapter pattern for interface compatibility
- ✅ Implementing Iterator pattern for collection traversal
- ✅ Polymorphism and interface implementation
- ✅ Collection management in Java
- ✅ Design pattern benefits and trade-offs

## Notes
- The InventoryManager is thread-safe for basic operations
- Iterator provides fail-safe collection traversal
- Adapter pattern enables legacy code integration
