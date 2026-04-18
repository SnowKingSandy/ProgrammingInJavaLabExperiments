import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    
    // ============ Restaurant Operations ============
    
    public static void insertRestaurant(String name, String location, String cuisine) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO Restaurant (Name, Location, Cuisine) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setString(3, cuisine);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error inserting restaurant: " + e.getMessage());
        }
    }
    
    public static List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Restaurant";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Restaurant r = new Restaurant(
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getString("Location"),
                    rs.getString("Cuisine")
                );
                restaurants.add(r);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving restaurants: " + e.getMessage());
        }
        return restaurants;
    }
    
    public static void updateRestaurant(int id, String name, String location, String cuisine) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE Restaurant SET Name=?, Location=?, Cuisine=? WHERE Id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, location);
            stmt.setString(3, cuisine);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error updating restaurant: " + e.getMessage());
        }
    }
    
    public static void deleteRestaurant(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM Restaurant WHERE Id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error deleting restaurant: " + e.getMessage());
        }
    }
    
    // ============ MenuItem Operations ============
    
    public static void insertMenuItem(String name, int price, int restaurantId) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, restaurantId);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error inserting menu item: " + e.getMessage());
        }
    }
    
    public static List<MenuItem> getAllMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT m.Id, m.Name, m.Price, r.Name as RestaurantName, m.ResId " +
                          "FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("Id"),
                    rs.getString("m.Name"),
                    rs.getInt("Price"),
                    rs.getString("RestaurantName"),
                    rs.getInt("ResId")
                );
                items.add(item);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving menu items: " + e.getMessage());
        }
        return items;
    }
    
    public static void updateMenuItem(int id, String name, int price) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE MenuItem SET Name=?, Price=? WHERE Id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error updating menu item: " + e.getMessage());
        }
    }
    
    public static void deleteMenuItem(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM MenuItem WHERE Id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error deleting menu item: " + e.getMessage());
        }
    }
}
