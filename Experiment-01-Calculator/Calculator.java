import java.util.Scanner;

public class Calculator {
    int choice, num1, num2;

    // Logic Methods
    public double addNums(int n1, int n2) {
        return n1 + n2;
    }

    public double subtractNums(int n1, int n2) {
        return n1 - n2;
    }

    public double multiplyNums(int n1, int n2) {
        return n1 * n2;
    }

    public double divideNums(int n1, int n2) {
        return (double) n1 / n2;
    }

    public double calcMod(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        char continueChoice;

        do {
            System.out.println("Enter the operation: \n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Remainder");
            
            if(scan.hasNextInt()) {
                calc.choice = scan.nextInt();
            } else {
                scan.next();
                System.out.println("Invalid input.");
                continueChoice = 'y'; 
                continue;
            }

            System.out.println("Enter First Number: ");
            calc.num1 = scan.nextInt();
            System.out.println("Enter Second Number: ");
            calc.num2 = scan.nextInt();

            // Switch Logic
            switch (calc.choice) {
                case 1 -> System.out.println("Addition: " + calc.addNums(calc.num1, calc.num2));
                case 2 -> System.out.println("Subtraction: " + calc.subtractNums(calc.num1, calc.num2));
                case 3 -> System.out.println("Multiplication: " + calc.multiplyNums(calc.num1, calc.num2));
                case 4 -> System.out.println("Division: " + calc.divideNums(calc.num1, calc.num2));
                case 5 -> System.out.println("Remainder: " + calc.calcMod(calc.num1, calc.num2));
                default -> System.out.println("Invalid Operation Selected");
            }

            System.out.println("Do you want to continue? (y/n): ");
            continueChoice = scan.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        scan.close();
    }
}