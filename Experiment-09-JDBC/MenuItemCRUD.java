import java.sql.*;

public class MenuItemCRUD {
    
    public static void insertMenuItems() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO MenuItem (Id, Name, Price, ResId) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            String[][] data = {
                {"1", "Espresso", "45", "1"},
                {"2", "Cappuccino", "65", "1"},
                {"3", "Pasta Carbonara", "150", "2"},
                {"4", "Risotto", "180", "2"},
                {"5", "Pad Thai", "120", "3"},
                {"6", "Pork Burgers", "95", "4"},
                {"7", "Cheese Burger", "85", "4"},
                {"8", "Pepperoni Pizza", "200", "5"},
                {"9", "Margherita Pizza", "150", "5"},
                {"10", "Salmon Sushi", "250", "6"}
            };
            
            for (String[] row : data) {
                stmt.setInt(1, Integer.parseInt(row[0]));
                stmt.setString(2, row[1]);
                stmt.setInt(3, Integer.parseInt(row[2]));
                stmt.setInt(4, Integer.parseInt(row[3]));
                stmt.addBatch();
            }
            
            stmt.executeBatch();
            System.out.println("10 MenuItem records inserted successfully.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error inserting menu items: " + e.getMessage());
        }
    }
    
    public static void selectPriceLessThan100() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT m.Id, m.Name, m.Price, r.Name as Restaurant FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE m.Price <= 100 ORDER BY m.Price";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("\n--- Menu Items with Price <= 100 ---");
            System.out.printf("%-5s %-20s %-8s %-20s%n", "ID", "Item Name", "Price", "Restaurant");
            System.out.println("-----------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-8d %-20s%n", rs.getInt("Id"), rs.getString("Name"), rs.getInt("Price"), rs.getString("Restaurant"));
            }
            
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error selecting items with price <= 100: " + e.getMessage());
        }
    }
    
    public static void selectFromCafeJava() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT m.Id, m.Name, m.Price FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE r.Name = 'Cafe Java'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("\n--- Menu Items from Cafe Java ---");
            System.out.printf("%-5s %-20s %-8s%n", "ID", "Item Name", "Price");
            System.out.println("-------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-8d%n", rs.getInt("Id"), rs.getString("Name"), rs.getInt("Price"));
            }
            
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error selecting items from Cafe Java: " + e.getMessage());
        }
    }
    
    public static void updatePriceLessThan100() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE MenuItem SET Price = 200 WHERE Price <= 100";
            Statement stmt = conn.createStatement();
            int rowsUpdated = stmt.executeUpdate(query);
            
            System.out.println("\nUpdated " + rowsUpdated + " menu items (Price <= 100 changed to 200).");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error updating menu items: " + e.getMessage());
        }
    }
    
    public static void deleteNameStartsWithP() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
            Statement stmt = conn.createStatement();
            int rowsDeleted = stmt.executeUpdate(query);
            
            System.out.println("\nDeleted " + rowsDeleted + " menu items starting with 'P'.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error deleting menu items: " + e.getMessage());
        }
    }
    
    public static void displayAllMenuItems() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT m.Id, m.Name, m.Price, r.Name as Restaurant FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id ORDER BY m.Id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("\n--- All Menu Items ---");
            System.out.printf("%-5s %-20s %-8s %-20s%n", "ID", "Item Name", "Price", "Restaurant");
            System.out.println("-----------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-8d %-20s%n", rs.getInt("Id"), rs.getString("Name"), rs.getInt("Price"), rs.getString("Restaurant"));
            }
            
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error displaying menu items: " + e.getMessage());
        }
    }
}
