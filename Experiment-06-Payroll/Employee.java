public abstract class Employee {
    protected String empId;
    protected String name;
    protected String panNo;
    protected String joiningDate;
    protected String designation;

    public Employee(String name, String panNo, String joiningDate, String designation, String empId) {
        this.empId = empId;
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    public abstract double calcCTC();
    
    public void displayInfo() {
        System.out.println("Name: " + name + " | ID: " + empId + " | Role: " + designation);
    }
}
