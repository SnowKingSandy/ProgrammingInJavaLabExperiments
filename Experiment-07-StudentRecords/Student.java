public class Student {
    public int studentId;
    public String name;
    public String branch;
    public int marks1;
    public int marks2;
    public int marks3;
    public int marks4;
    public int marks5;
    public double percentage;

    public Student(int studentId, String name, String branch, int marks1, int marks2, int marks3, int marks4, int marks5) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
        this.percentage = calculatePercentage();
    }

    public double calculatePercentage() {
        int total = marks1 + marks2 + marks3 + marks4 + marks5;
        return (total / 500.0) * 100;
    }

    public String toCSV() {
        return studentId + "," + name + "," + branch + "," + marks1 + "," + marks2 + "," + marks3 + "," + marks4 + "," + marks5 + "," + String.format("%.2f", percentage);
    }
}
