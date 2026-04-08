import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("Welcome to Student Record Management System\n");

        while (keepRunning) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Create - Add 3 new students");
            System.out.println("2. Read - Display all students");
            System.out.println("3. Update - Update student marks");
            System.out.println("4. Delete - Remove a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Creating 3 New Students ---");
                    StudentCreate.addStudent(103, "Amit Patel", "CSE", 88, 91, 85, 0, 0);
                    StudentCreate.addStudent(104, "Deepika Singh", "ECE", 90, 87, 92, 0, 0);
                    StudentCreate.addStudent(105, "Vikram Gupta", "MECH", 79, 83, 81, 0, 0);
                    break;

                case 2:
                    System.out.println("\n--- Reading All Students ---");
                    StudentDisplay.showAllRecords();
                    break;

                case 3:
                    System.out.println("\n--- Update Student Marks ---");
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter Marks1: ");
                    int m1 = scanner.nextInt();
                    System.out.print("Enter Marks2: ");
                    int m2 = scanner.nextInt();
                    System.out.print("Enter Marks3: ");
                    int m3 = scanner.nextInt();
                    System.out.print("Enter Marks4: ");
                    int m4 = scanner.nextInt();
                    System.out.print("Enter Marks5: ");
                    int m5 = scanner.nextInt();
                    StudentUpdate.updateStudentMarks(updateId, m1, m2, m3, m4, m5);
                    break;

                case 4:
                    System.out.println("\n--- Delete Student ---");
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    StudentDelete.deleteStudent(deleteId);
                    break;

                case 5:
                    keepRunning = false;
                    System.out.println("\nFinal Student Records:");
                    StudentDisplay.showAllRecords();
                    System.out.println("\nExiting Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }

        scanner.close();
    }
}
