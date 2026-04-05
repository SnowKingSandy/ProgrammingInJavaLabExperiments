public class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected double perfBonus;
    protected double hiringCommission;
    protected String role;

    public FullTimeEmployee(String name, String panNo, String joiningDate, String designation, String empId, double baseSalary, double perfBonus, double hiringCommission, String role) {
        super(name, panNo, joiningDate, designation, empId);
        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.hiringCommission = hiringCommission;
        this.role = role;
    }

    @Override
    public double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } else if (role.equalsIgnoreCase("HR")) {
            return baseSalary + hiringCommission;
        }
        return baseSalary;
    }
}
