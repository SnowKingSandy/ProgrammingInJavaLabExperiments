public class Manager extends FullTimeEmployee {
    private double TA;
    private double eduAllowance;

    public Manager(String name, String panNo, String joiningDate, String empId, double baseSalary, double perfBonus, double TA, double eduAllowance) {
        super(name, panNo, joiningDate, "Manager", empId, baseSalary, perfBonus, 0.0, "Manager");
        this.TA = TA;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + perfBonus + TA + eduAllowance;
    }
}
