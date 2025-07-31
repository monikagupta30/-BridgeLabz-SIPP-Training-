import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Define source and destination file paths
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Try to open the source file
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            // Create input and output streams
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(destFile); // Automatically creates file if it doesn't exist

            // Read and write byte by byte
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Always close streams in finally block
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing the file streams: " + e.getMessage());
            }
        }
    }
}
