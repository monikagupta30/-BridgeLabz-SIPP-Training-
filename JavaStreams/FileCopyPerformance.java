import java.io.*;

public class FileCopyPerformance {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";       // Ensure this file is ~100MB
        String unbufferedDest = "unbuffered_copy.dat";
        String bufferedDest = "buffered_copy.dat";

        // Copy using unbuffered streams
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, unbufferedDest);
        System.out.println("Unbuffered Copy Time: " + unbufferedTime + " nanoseconds");

        // Copy using buffered streams
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedDest);
        System.out.println("Buffered Copy Time: " + bufferedTime + " nanoseconds");

        // Compare
        System.out.println("\nBuffered is " +
                (unbufferedTime / (double) bufferedTime) +
                " times faster than unbuffered (approx).");
    }

    // Method for unbuffered copy
    public static long copyUsingUnbufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy failed: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    // Method for buffered copy
    public static long copyUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy failed: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}
