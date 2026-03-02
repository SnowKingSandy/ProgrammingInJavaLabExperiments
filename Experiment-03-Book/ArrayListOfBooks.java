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

            try {
                Book testBook = new Book("Test Item", -50.0, "978-999999", "fiction", "Anonymous");
            } catch (InvalidPriceException e) {
                System.out.println("Error - " + e.getMessage());
            }

        } catch (InvalidGenreException | InvalidPriceException e) {
            System.out.println("Error adding book to library: " + e.getMessage());
            
        } finally {
            
            System.out.println("\n--- Library Collection ---");
            
            if (library.isEmpty()) {
                System.out.println("The library is currently empty.");
            } else {
                System.out.println("\nBooks Added:");
                for (Book b : library) {
                    System.out.println(b.title + " | " + b.author + " | $" + b.price);
                }

                System.out.println("Total: " + library.size() + " books");
                
                if (b2 != null) {
                    System.out.println("Contains 'The Alchemist': " + library.contains(b2));
                }

                double sum = 0;
                for (Book b : library) {
                    sum = sum + b.price;
                }

                double average = sum / library.size();
                System.out.println("\nBook Prices:");
                for (Book b : library) {
                    System.out.println(b.title + " - $" + b.price);
                }

                System.out.println("\nSum: $" + sum);
                System.out.println("Average: $" + String.format("%.2f", average));

                System.out.println("\nFiction:");
                library.forEach(book -> {
                    if (book.genre.equalsIgnoreCase("fiction")) {
                        System.out.println("  " + book.title + " by " + book.author);
                    }
                });
            }
            
            System.out.println("\n--- System execution complete ---");
        }
    }
}
