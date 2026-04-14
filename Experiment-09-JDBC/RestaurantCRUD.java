import java.sql.*;

public class RestaurantCRUD {
    
    public static void insertRestaurants() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO Restaurant (Id, Name, Address) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            String[][] data = {
                {"1", "Cafe Java", "123 Main St"},
                {"2", "The Italian Place", "456 Oak Ave"},
                {"3", "Dragon Palace", "789 Park Rd"},
                {"4", "Burger Barn", "321 Elm St"},
                {"5", "Pizza Palace", "654 Pine Ave"},
                {"6", "Sushi House", "987 Maple St"},
                {"7", "Taco Fiesta", "147 Cedar Ln"},
                {"8", "The Grill", "258 Birch Ave"},
                {"9", "Cafe Sunrise", "369 Willow St"},
                {"10", "Orient Express", "741 Spruce Ave"}
            };
            
            for (String[] row : data) {
                stmt.setInt(1, Integer.parseInt(row[0]));
                stmt.setString(2, row[1]);
                stmt.setString(3, row[2]);
                stmt.addBatch();
            }
            
            stmt.executeBatch();
            System.out.println("10 Restaurant records inserted successfully.");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error inserting restaurants: " + e.getMessage());
        }
    }
    
    public static void displayAllRestaurants() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Restaurant";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("\n--- All Restaurants ---");
            System.out.printf("%-5s %-20s %-30s%n", "ID", "Name", "Address");
            System.out.println("------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-30s%n", rs.getInt("Id"), rs.getString("Name"), rs.getString("Address"));
            }
            
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error displaying restaurants: " + e.getMessage());
        }
    }
}
