import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeDatabase = new ArrayList<>();
        boolean keepRunning = true;

        System.out.println("Welcome to the Employee CTC Calculator");

        while (keepRunning) {
            System.out.println("\nEmployee Creation Menu");
            System.out.println("1. Add Software Engineer (SWE)");
            System.out.println("2. Add HR Specialist (HR)");
            System.out.println("3. Add Contract Employee");
            System.out.println("4. Add Manager");
            System.out.println("5. View All Employees and Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 5) {
                keepRunning = false;
                continue;
            }

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter PAN Number: ");
                String panNo = scanner.nextLine();
                
                System.out.print("Enter Joining Date (DD-MM-YYYY): ");
                String joiningDate = scanner.nextLine();
                
                System.out.print("Enter Employee ID: ");
                String empId = scanner.nextLine();

                switch (choice) {
                    case 1: 
                        System.out.print("Enter Base Salary: ");
                        double sweBase = scanner.nextDouble();
                        System.out.print("Enter Performance Bonus: ");
                        double sweBonus = scanner.nextDouble();
                        
                        FullTimeEmployee swe = new FullTimeEmployee(name, panNo, joiningDate, "Software Engineer", empId, sweBase, sweBonus, 0, "SWE");
                        employeeDatabase.add(swe);
                        System.out.println("Software Engineer Created Successfully. CTC: $" + swe.calcCTC());
                        break;

                    case 2: 
                        System.out.print("Enter Base Salary: ");
                        double hrBase = scanner.nextDouble();
                        System.out.print("Enter Hiring Commission: ");
                        double hrCommission = scanner.nextDouble();
                        
                        FullTimeEmployee hr = new FullTimeEmployee(name, panNo, joiningDate, "HR Specialist", empId, hrBase, 0, hrCommission, "HR");
                        employeeDatabase.add(hr);
                        System.out.println("HR Specialist Created Successfully. CTC: $" + hr.calcCTC());
                        break;

                    case 3: 
                        System.out.print("Enter Designation/Role: ");
                        String contractRole = scanner.nextLine();
                        System.out.print("Enter Number of Hours Worked: ");
                        double hrs = scanner.nextDouble();
                        System.out.print("Enter Hourly Rate: ");
                        double rate = scanner.nextDouble();
                        
                        ContractEmployee contractor = new ContractEmployee(name, panNo, joiningDate, contractRole, empId, hrs, rate);
                        employeeDatabase.add(contractor);
                        System.out.println("Contract Employee Created Successfully. CTC: $" + contractor.calcCTC());
                        break;

                    case 4: 
                        System.out.print("Enter Base Salary: ");
                        double mgrBase = scanner.nextDouble();
                        System.out.print("Enter Performance Bonus: ");
                        double mgrBonus = scanner.nextDouble();
                        System.out.print("Enter Travel Allowance (TA): ");
                        double ta = scanner.nextDouble();
                        System.out.print("Enter Education Allowance: ");
                        double eduAllow = scanner.nextDouble();
                        
                        Manager manager = new Manager(name, panNo, joiningDate, empId, mgrBase, mgrBonus, ta, eduAllow);
                        employeeDatabase.add(manager);
                        System.out.println("Manager Created Successfully. CTC: $" + manager.calcCTC());
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }

        System.out.println("\nFinal Employee Report");
        System.out.println("Total Employees Created: " + employeeDatabase.size());
        
        for (Employee emp : employeeDatabase) {
            System.out.println();
            emp.displayInfo();
            System.out.println("Calculated CTC: $" + emp.calcCTC());
        }
        
        scanner.close();
        System.out.println("\nProgram Terminated Successfully.");
    }
}
