public class MenuItem {
    private int id;
    private String name;
    private int price;
    private String restaurantName;
    private int restaurantId;
    
    public MenuItem(int id, String name, int price, String restaurantName, int restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getRestaurantName() { return restaurantName; }
    public int getRestaurantId() { return restaurantId; }
    
    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }
    
    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + restaurantName;
    }
}
