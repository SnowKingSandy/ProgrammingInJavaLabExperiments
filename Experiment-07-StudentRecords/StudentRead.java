import java.io.*;

public class StudentRead {
    public static void displayAllStudents() {
        try {
            FileReader fr = new FileReader("Students.csv");
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                if (lineCount == 0) {
                    System.out.println(line);
                } else {
                    System.out.println(line);
                }
                lineCount++;
            }
            
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
