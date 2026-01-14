// Importing Scanner class for user input
import java.util.Scanner;

// Defining the Calculator Class
public class Calculator {
    // Declaring instance variables for user choice and numbers
    int choice, num1, num2;

    // Method for addition of two numbers
    public double addNums(int n1, int n2) {
        return n1 + n2;
    }

    // Method for subtraction of two numbers
    public double subtractNums(int n1, int n2) {
        return n1 - n2;
    }

    // Method for multiplication of two numbers
    public double multiplyNums(int n1, int n2) {
        return n1 * n2;
    }

    // Method for division of two numbers with zero-division check
    public double divideNums(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Division by Zero is Not Defined.");
        }
        return (double) n1 / n2;
    }

    // Method for calculating the remainder of two numbers with zero-division check
    public double calcMod(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Modulo by Zero is Not Defined.");
        }
        return n1 % n2;
    }

    // Main method to execute the calculator operations
    public static void main(String[] args) {
        // Creating an instance of Calculator and Scanner for user input
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        // Variable to control the continuation of operations
        char continueChoice;

        do {
            // Displaying operation choices to the user
            System.out.println("Enter the operation: \n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Remainder");
            calc.choice = scan.nextInt();

            // Taking input for the two numbers
            System.out.println("Enter First Number: ");
            calc.num1 = scan.nextInt();

            System.out.println("Enter Second Number: ");
            calc.num2 = scan.nextInt();

            // Performing the selected operation and displaying the result using switch-case
            switch (calc.choice) {
                case 1 -> System.out.println("Addition: " + calc.addNums(calc.num1, calc.num2));
                case 2 -> System.out.println("Subtraction: " + calc.subtractNums(calc.num1, calc.num2));
                case 3 -> System.out.println("Multiplication: " + calc.multiplyNums(calc.num1, calc.num2));
                case 4 -> {
                    try {
                        System.out.println("Division: " + calc.divideNums(calc.num1, calc.num2));
                    } 
                    // Division by zero error handling
                    catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        System.out.println("Remainder: " + calc.calcMod(calc.num1, calc.num2));
                    } 
                    // Modulo by zero error handling
                    catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                }
                default -> System.out.println("Invalid Operation Selected");
            }
            // Asking user if they want to continue
            System.out.println("Do you want to continue? (y/n): ");
            continueChoice = scan.next().charAt(0);

        } while (continueChoice == 'y');

        // Closing the scanner
        scan.close();
    }
}