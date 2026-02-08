import java.time.Year;
import java.util.Scanner;

public class Vehicle {
    // Private Encapsulated Data
    private String vinNumber;
    private int curSpeed;
    private double mileage;
    
    // Public Data
    public String brandName;
    public String modelName;
    public String color;
    public int noOfSeats;
    public float fuelCapacity;
    public char fuelType; 
    public java.time.Year yearOfMfg;
    public double weight;
    public double price;

    // 1. Default Constructor
    public Vehicle() {
        this.vinNumber = "N/A";
        this.brandName = "Standard Brand";
        this.modelName = "Base Model";
        this.color = "White";
        this.noOfSeats = 4;
        this.fuelCapacity = 40.0f;
        this.fuelType = 'P';
        this.yearOfMfg = Year.now();
        this.weight = 1000.0;
        this.price = 15000.0;
        this.curSpeed = 0;
        this.mileage = 0.0;
    }

    // 2. Parameterized Constructor
    public Vehicle(String vinNumber, String brandName, String modelName, String color, 
                   int noOfSeats, float fuelCapacity, char fuelType, Year yearOfMfg, 
                   double weight, double price) {
        this.vinNumber = vinNumber;
        this.curSpeed = 0;
        this.brandName = brandName;
        this.modelName = modelName;
        this.color = color;
        this.noOfSeats = noOfSeats;
        this.fuelCapacity = fuelCapacity;
        this.fuelType = fuelType;
        this.yearOfMfg = yearOfMfg;
        this.weight = weight;
        this.price = price;
        this.mileage = 0.0;
    }

    // 3. Copy Constructor
    public Vehicle(Vehicle other) {
        this.vinNumber = other.vinNumber;
        this.curSpeed = other.curSpeed;
        this.brandName = other.brandName;
        this.modelName = other.modelName;
        this.color = other.color;
        this.noOfSeats = other.noOfSeats;
        this.fuelCapacity = other.fuelCapacity;
        this.fuelType = other.fuelType;
        this.yearOfMfg = other.yearOfMfg;
        this.weight = other.weight;
        this.price = other.price;
        this.mileage = other.mileage;
    }

    // Getters and Setters
    public String getVinNumber() { return vinNumber; }
    public void setVinNumber(String vinNumber) { this.vinNumber = vinNumber; }
    public double getMileage() { return mileage; }

    public void displayDetails() {
        System.out.println("Vehicle: " + brandName + " " + modelName + " (" + fuelType + ")");
    }
}
