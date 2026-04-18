# Experiment 10: JavaFX JDBC Restaurant Management Application

## Objective
This experiment combines JavaFX GUI framework with JDBC database connectivity to create a comprehensive Restaurant Management System. It demonstrates professional desktop application development with real-time database operations through an intuitive graphical user interface.

## Key Concepts Covered
- **JavaFX GUI Components**: TableView, Tab, Dialog, ComboBox, TextField
- **JDBC Integration**: PreparedStatement, ResultSet, Join queries
- **CRUD Operations**: Create, Read, Update, Delete via GUI
- **MVC Pattern**: Separation of data models from UI
- **Event Handling**: Button clicks, dialog interactions
- **Data Binding**: ObservableList for real-time table updates
- **Database Schema**: Restaurant-MenuItem relationships with foreign keys

## Architecture

### Model Classes
- **Restaurant.java**: POJO representing restaurant data
- **MenuItem.java**: POJO representing menu item data

### Database Layer
- **DatabaseConnection.java**: Singleton for JDBC connections
- **DatabaseManager.java**: CRUD operations for both entities

### UI Layer
- **RestaurantManagementApp.java**: Main JavaFX application with two tabs

## Class Details

### Restaurant.java
```java
- id: int
- name: String
- location: String
- cuisine: String
- Getters/Setters for all attributes
```

### MenuItem.java
```java
- id: int
- name: String
- price: int
- restaurantName: String
- restaurantId: int
- Getters/Setters for all attributes
```

### DatabaseManager.java
Static methods for CRUD operations:
```java
// Restaurant Operations
insertRestaurant(String name, String location, String cuisine)
getAllRestaurants(): List<Restaurant>
updateRestaurant(int id, String name, String location, String cuisine)
deleteRestaurant(int id)

// MenuItem Operations
insertMenuItem(String name, int price, int restaurantId)
getAllMenuItems(): List<MenuItem>
updateMenuItem(int id, String name, int price)
deleteMenuItem(int id)
```

### RestaurantManagementApp.java
JavaFX Application with:
- Tab 1: Restaurant management (Add, Update, Delete, Display)
- Tab 2: Menu item management (Add, Update, Delete, Display)
- Real-time table updates
- Input validation dialogs
- Error handling and user feedback

## Database Schema

### Restaurants Table
```sql
CREATE TABLE Restaurant (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Location VARCHAR(100),
    Cuisine VARCHAR(50)
);
```

### MenuItems Table
```sql
CREATE TABLE MenuItem (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Price INT,
    ResId INT,
    FOREIGN KEY (ResId) REFERENCES Restaurant(Id) ON DELETE CASCADE
);
```

## Running the Application

### Prerequisites
- Java 11+
- JavaFX SDK (download from gluonhq.com)
- MySQL Server running
- MySQL Connector JAR file
- Database and tables created

### Setup Steps

1. **Create Database and Tables**
```bash
mysql -u root -p < schema.sql
```

2. **Configure Credentials**
Edit `database.properties`:
```properties
db.url=jdbc:mysql://localhost:3306/RestaurantDB
db.user=your_username
db.password=your_password
db.driver=com.mysql.cj.jdbc.Driver
```

3. **Compile with JavaFX**
```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls *.java
```

4. **Run Application**
```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls RestaurantManagementApp
```

## Features

### Restaurant Management Tab
- ✅ **Add Restaurant**: Opens dialog to enter name, location, cuisine
- ✅ **Update Restaurant**: Modify selected restaurant details
- ✅ **Delete Restaurant**: Remove restaurant with confirmation
- ✅ **Display All**: TableView shows all restaurants
- ✅ **Refresh**: Reload data from database

### Menu Item Management Tab
- ✅ **Add Menu Item**: Dialog with restaurant selection dropdown
- ✅ **Update Menu Item**: Modify name and price
- ✅ **Delete Menu Item**: Remove items with confirmation
- ✅ **Display All**: TableView with join to restaurant names
- ✅ **Refresh**: Reload data from database

## Learning Outcomes
- ✅ Professional JavaFX application development
- ✅ JDBC integration with GUI applications
- ✅ CRUD operations through desktop UI
- ✅ Database relationships and joins
- ✅ Event handling and user interaction
- ✅ Data validation and error handling
- ✅ Real-time data binding with ObservableList
- ✅ MVC architectural pattern

## Security Notes
- Database credentials stored in `database.properties` (excluded from git)
- Each developer maintains their own local configuration
- Input validation for all user entries
- SQL injection prevention using PreparedStatement

## Screenshots
The application displays:
1. Clean tabbed interface
2. TableView with sortable columns
3. Responsive CRUD buttons
4. Input dialogs with validation
5. Confirmation dialogs for destructive operations

## Future Enhancements
- Search and filter functionality
- Report generation (PDF export)
- User authentication
- Role-based permissions
- Image support for restaurants
- Rating and review system
