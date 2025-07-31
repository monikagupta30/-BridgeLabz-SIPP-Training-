import java.io.*;

public class ImageByteArrayConversion {

    public static void main(String[] args) {
        String inputImagePath = "input.jpg";       // Replace with your actual image file
        String outputImagePath = "output.jpg";     // The new image file

        try {
            // Step 1: Read image file into byte array
            byte[] imageBytes = readImageToByteArray(inputImagePath);

            // Step 2: Write byte array to new image file
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image successfully converted to byte array and written to '" + outputImagePath + "'");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to read image file to byte array using ByteArrayOutputStream
    public static byte[] readImageToByteArray(String imagePath) throws IOException {
        FileInputStream fis = new FileInputStream(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        fis.close();
        return baos.toByteArray();
    }

    // Method to write byte array to image file using ByteArrayInputStream
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream(outputPath);

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = bais.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        bais.close();
        fos.close();
    }
}
