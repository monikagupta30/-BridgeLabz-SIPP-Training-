import java.io.*;

public class ErrorLineFilter {
    public static void main(String[] args) {
        String filePath = "largefile.txt";  // Replace with your actual file path

        // Use try-with-resources to ensure file is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line and check for "error" (case-insensitive)
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
