public class Book {
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    // 1. Default Constructor
    public Book() {
        this.title = "Unknown";
        this.price = 0.0;
        this.ISBN = "000-0000";
        this.genre = "General";
        this.author = "Anonymous";
    }

    // 2. Parameterized Constructor
    public Book(String title, double price, String ISBN, String genre, String author) throws InvalidPriceException, InvalidGenreException {
        this.title = title;
        if (price < 0.0){
            throw new InvalidPriceException("Price Cannot be Negative");
        }
        this.price = price;
        this.ISBN = ISBN;
        
        if (!genre.equalsIgnoreCase("fiction") && !genre.equalsIgnoreCase("poetry") && !genre.equalsIgnoreCase("dystopian")) {
            throw new InvalidGenreException("Genre must be 'fiction', 'poetry', or 'dystopian'. Received: " + genre);
        }
        this.genre = genre;
        this.author = author;
    }

    // 3. Copy Constructor
    public Book(Book other) {
        this.title = other.title;
        this.price = other.price;
        this.ISBN = other.ISBN;
        this.genre = other.genre;
        this.author = other.author;
    }

    // Display book details
    public void displayDetails() {
        System.out.println("Title: " + title + " | Author: " + author + " | Price: $" + price + " | Genre: " + genre + " | ISBN: " + ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", ISBN='" + ISBN + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
