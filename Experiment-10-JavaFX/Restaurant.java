public class Restaurant {
    private int id;
    private String name;
    private String location;
    private String cuisine;
    
    public Restaurant(int id, String name, String location, String cuisine) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getCuisine() { return cuisine; }
    
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    
    @Override
    public String toString() {
        return id + " | " + name + " | " + location + " | " + cuisine;
    }
}
