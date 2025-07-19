import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        // Specify the path to your file
        String filePath = "example.txt";  // Ensure this file exists and is encoded in UTF-8

        try (
            // Step 1: Create a FileInputStream to read binary data from the file
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // Step 2: Wrap FileInputStream with InputStreamReader specifying UTF-8 charset
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            // Step 3: Wrap InputStreamReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            // Step 4: Read the file line by line and print to console
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnsupportedEncodingException e) {
            System.out.println("The character encoding is not supported: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
