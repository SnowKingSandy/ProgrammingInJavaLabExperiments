import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employeeDatabase = new ArrayList<>();
        
        FullTimeEmployee swe = new FullTimeEmployee("Alice Johnson", "ABCDE1234F", "15-01-2020", "Software Engineer", "EMP001", 100000, 15000, 0, "SWE");
        employeeDatabase.add(swe);
        
        FullTimeEmployee hr = new FullTimeEmployee("Bob Smith", "XYZAB5678G", "10-06-2019", "HR Specialist", "EMP002", 80000, 0, 12000, "HR");
        employeeDatabase.add(hr);
        
        ContractEmployee contractor = new ContractEmployee("Carol White", "PQRST9012H", "01-03-2023", "Contract Developer", "EMP003", 160, 500);
        employeeDatabase.add(contractor);
        
        Manager manager = new Manager("Dave Brown", "LMNOP3456I", "22-11-2018", "EMP004", 150000, 25000, 5000, 3000);
        employeeDatabase.add(manager);
        
        System.out.println("Employee Payroll Report\n");
        for (Employee emp : employeeDatabase) {
            emp.displayInfo();
            System.out.println("CTC: $" + emp.calcCTC());
            System.out.println();
        }
        
        System.out.println("Total Employees: " + employeeDatabase.size());
    }
}
