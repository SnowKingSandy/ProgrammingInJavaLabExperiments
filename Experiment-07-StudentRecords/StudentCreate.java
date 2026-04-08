import java.io.*;

public class StudentCreate {
    public static void addStudent(int id, String name, String branch, int m1, int m2, int m3, int m4, int m5) {
        try {
            FileWriter fw = new FileWriter("Students.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            Student student = new Student(id, name, branch, m1, m2, m3, m4, m5);
            bw.write(student.toCSV());
            bw.newLine();
            
            bw.close();
            fw.close();
            System.out.println("Successfully added student: " + name);
        } catch (IOException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
}
