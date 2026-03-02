import java.util.ArrayList;

public class ArrayListOfBooks {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<Book>();
        Book b1 = null;
        Book b2 = null;
        Book b3 = null;
        Book b4 = null;

        try {
            b1 = new Book("Icon", 29.99, "978-031254", "fiction", "Steve Jobs");
            library.add(b1);

            b2 = new Book("The Alchemist", 14.50, "978-006112", "poetry", "Paulo Coelho");
            library.add(b2);

            b3 = new Book("1984", 11.99, "978-045152", "dystopian", "George Orwell");
            library.add(b3);

            b4 = new Book("Harry Potter", 25.99, "978-073475", "fiction", "J.K. Rowling");
            library.add(b4);

            // Try to create a book with negative price
            System.out.println("\nAttempting to create a book with negative price...");
            try {
                Book invalidBook = new Book("Invalid Book", -50.0, "978-999999", "fiction", "Anonymous");
            } catch (InvalidPriceException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            }

        } catch (InvalidGenreException | InvalidPriceException e) {
            System.out.println("Error adding book to library: " + e.getMessage());
            
        } finally {
            
            System.out.println("\n--- Library Collection ---");
            
            if (library.isEmpty()) {
                System.out.println("The library is currently empty.");
            } else {
                System.out.println("\nAll Books in Library:");
                for (Book b : library) {
                    System.out.println(b.title + " | " + b.author + " | $" + b.price);
                }

                System.out.println("\nTotal Books: " + library.size());
                
                if (b2 != null) {
                    System.out.println("Is 'The Alchemist' in the list? " + library.contains(b2));
                }

                // Calculate average price
                double sum = 0;
                for (Book b : library) {
                    sum = sum + b.price;
                }

                double average = sum / library.size();
                System.out.println("\nPrice Details:");
                for (Book b : library) {
                    System.out.println(b.title + " | Price: $" + b.price);
                }

                System.out.println("\nTotal Sum: $" + sum);
                System.out.println("Average Price: $" + String.format("%.2f", average));

                // Print Fiction books using forEach
                System.out.println("\n--- Fiction Books ---");
                library.forEach(book -> {
                    if (book.genre.equalsIgnoreCase("fiction")) {
                        System.out.println(book.title + " by " + book.author + " ($" + book.price + ")");
                    }
                });
            }
            
            System.out.println("\n--- System execution complete ---");
        }
    }
}
