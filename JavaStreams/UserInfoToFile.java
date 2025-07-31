import java.io.*;

public class UserInfoToFile {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            // Set up reader to read from console
            reader = new BufferedReader(new InputStreamReader(System.in));

            // Read user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Set up writer to write to a file
            writer = new FileWriter("user_info.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User information saved successfully to 'user_info.txt'.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
