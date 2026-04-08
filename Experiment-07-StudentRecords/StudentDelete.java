import java.io.*;
import java.util.*;

public class StudentDelete {
    public static void deleteStudent(int targetId) {
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
                    
                    if (id != targetId) {
                        bw.write(lines.get(i));
                        bw.newLine();
                    } else {
                        found = true;
                    }
                }
            }
            
            bw.close();
            fw.close();
            
            if (found) {
                System.out.println("Successfully deleted student ID: " + targetId);
            } else {
                System.out.println("Student ID not found: " + targetId);
            }
        } catch (IOException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
