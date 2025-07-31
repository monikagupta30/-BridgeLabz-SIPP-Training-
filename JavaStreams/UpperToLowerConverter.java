import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";      // Input text file
        String outputFile = "output.txt";    // Output text file

        // Use UTF-8 encoding to handle character encoding properly
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));

            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase and write to output
                writer.write(line.toLowerCase());
                writer.newLine(); // Preserve original line breaks
            }

            System.out.println("Conversion completed. Output saved to '" + outputFile + "'");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
