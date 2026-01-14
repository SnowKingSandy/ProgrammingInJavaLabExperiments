import java.util.Scanner;

public class Calculator {
    // Instance variables to store inputs
    int choice, num1, num2;

    // Main method: Entry point of the program
    public static void main(String[] args) {
        // 1. Setup Phase
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        char continueChoice;

        // 2. The Main Loop (UI Layer)
        do {
            // Display the Menu
            System.out.println("Enter the operation: \n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Remainder");
            
            // basic input validation to prevent crashes during testing
            if(scan.hasNextInt()) {
                calc.choice = scan.nextInt();
            } else {
                scan.next(); // clear bad input
                System.out.println("Invalid input. Restarting loop.");
                continueChoice = 'y'; 
                continue;
            }

            // Get the numbers
            System.out.println("Enter First Number: ");
            calc.num1 = scan.nextInt();

            System.out.println("Enter Second Number: ");
            calc.num2 = scan.nextInt();

            // 3. Logic Placeholder
            System.out.println("[System] Input received. Logic implementation pending...");
            System.out.println("You chose operation: " + calc.choice);
            System.out.println("Numbers: " + calc.num1 + ", " + calc.num2);

            // 4. Exit Condition
            System.out.println("Do you want to continue? (y/n): ");
            continueChoice = scan.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        // Cleanup
        scan.close();
        System.out.println("Calculator closed.");
    }
}