# Experiment 09: JDBC Application with CRUD Operations

## Objective
This experiment demonstrates advanced database connectivity using Java Database Connectivity (JDBC) API. It implements a complete Restaurant Management System with CRUD operations for both restaurants and menu items, demonstrating secure credential management through external properties file configuration.

## Key Concepts Covered
- **JDBC Connection Management**: Singleton pattern for database connections
- **SQL Operations**: INSERT, SELECT, UPDATE, DELETE queries
- **Prepared Statements**: Safe parameter binding to prevent SQL injection
- **Result Set Processing**: Iterating through query results with formatting
- **Exception Handling**: SQLException and ClassNotFoundException handling
- **External Configuration**: Secure credential storage in properties files
- **Modular Design**: Separate CRUD classes for each entity

## Project Structure

### Classes and Components

#### 1. **DatabaseConnection.java**
Implements a singleton pattern for managing database connections with secure property-based configuration.
- Loads database credentials from `database.properties` file
- Provides static `getConnection()` method
- Handles connection initialization and closure
- Implements connection pooling checks

#### 2. **RestaurantCRUD.java**
Handles restaurant data operations:
- `insertRestaurants()`: Adds 10 sample restaurant records
- `displayAllRestaurants()`: Displays all restaurants in tabular format

#### 3. **MenuItemCRUD.java**
Handles menu item management with 5 core operations:
- `insertMenuItems(10 records)`: Bulk insert sample menu items
- `selectPriceLessThan100()`: Filter items with price < 100
- `selectFromCafeJava()`: Retrieve items from specific restaurant
- `updatePriceLessThan100()`: Apply 10% discount to applicable items
- `deleteNameStartsWithP()`: Remove items starting with 'P'

#### 4. **Main.java**
Menu-driven interface for all database operations:
- 9 operation options including CRUD and filtering
- User input validation
- Exception handling and error reporting

## Database Setup

### Required Tables
```sql
-- Restaurants Table
CREATE TABLE Restaurants (
    RestaurantID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Location VARCHAR(100),
    Cuisine VARCHAR(50)
);

-- MenuItems Table
CREATE TABLE MenuItems (
    ItemID INT PRIMARY KEY AUTO_INCREMENT,
    RestaurantID INT NOT NULL,
    ItemName VARCHAR(100) NOT NULL,
    Price DECIMAL(8,2),
    FOREIGN KEY (RestaurantID) REFERENCES Restaurants(RestaurantID) ON DELETE CASCADE
);
```

### Configuration (.properties File)

Create a `database.properties` file in the Experiment-09-JDBC directory with your database credentials:

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/RestaurantDB
db.user=your_username
db.password=your_password
```

**⚠️ Security Note**: The `database.properties` file contains sensitive credentials and is excluded from version control via `.gitignore`. Each developer must create their own local copy with appropriate credentials.

## Running the Application

1. Ensure MySQL server is running
2. Create the database: `CREATE DATABASE RestaurantDB;`
3. Create the tables using the SQL scripts above
4. Create `database.properties` with your database credentials
5. Compile all Java files
6. Run `Main.java`

```bash
javac DatabaseConnection.java RestaurantCRUD.java MenuItemCRUD.java Main.java
java Main
```

## Sample Data
The application auto-populates sample data on first execution:
- 10 restaurants (including Café Java, Pizza Palace, Burger Hub, etc.)
- 10 menu items with prices and restaurant associations

## Learning Outcomes
- ✅ Secure database credential management
- ✅ JDBC API fundamentals
- ✅ SQL CRUD operations through Java
- ✅ Result set formatting and display
- ✅ Exception handling in database operations
- ✅ Modular application architecture
- ✅ Configuration management best practices

## Notes
- Database properties are kept separate from source code for security
- Singleton pattern ensures single connection instance
- All operations include appropriate error handling
- Foreign key constraints maintain data integrity between tables
