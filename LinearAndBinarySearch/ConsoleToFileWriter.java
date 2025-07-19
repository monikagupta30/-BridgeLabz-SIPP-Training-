import java.io.*;

class ConsoleToFileWriter {
    public static void main(String[] args) {
        // File to write user input
        String filePath = "user_input.txt";

        try (
            // Step 1: Create InputStreamReader to read from System.in
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            // Step 2: Wrap InputStreamReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Step 3: Create FileWriter to write to the file (append = false to overwrite)
            FileWriter fileWriter = new FileWriter(filePath)
        ) {
            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while (true) {
                // Step 4: Read input from the user
                line = bufferedReader.readLine();

                // Exit condition
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }

                // Step 5: Write the input to the file followed by a newline
                fileWriter.write(line + System.lineSeparator());
            }

            System.out.println("User input successfully written to " + filePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
