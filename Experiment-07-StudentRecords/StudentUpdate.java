import java.io.*;
import java.util.*;

public class StudentUpdate {
    public static void updateStudentMarks(int targetId, int m1, int m2, int m3, int m4, int m5) {
        try {
            FileReader fr = new FileReader("Students.csv");
            BufferedReader br = new BufferedReader(fr);
            
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
            fr.close();
            
            FileWriter fw = new FileWriter("Students.csv", false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                if (i == 0) {
                    bw.write(lines.get(i));
                    bw.newLine();
                } else {
                    String[] parts = lines.get(i).split(",");
                    int id = Integer.parseInt(parts[0]);
                    
                    if (id == targetId) {
                        Student updated = new Student(id, parts[1], parts[2], m1, m2, m3, m4, m5);
                        bw.write(updated.toCSV());
                        found = true;
                    } else {
                        bw.write(lines.get(i));
                    }
                    bw.newLine();
                }
            }
            
            bw.close();
            fw.close();
            
            if (found) {
                System.out.println("Successfully updated student ID: " + targetId);
            } else {
                System.out.println("Student ID not found: " + targetId);
            }
        } catch (IOException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
}
