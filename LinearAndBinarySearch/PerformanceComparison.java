import java.io.*;

public class PerformanceComparison {

    public static void main(String[] args) {
        // Part 1: Compare StringBuilder and StringBuffer
        compareStringBuilderVsStringBuffer();

        // Part 2: Compare FileReader and InputStreamReader
        String filePath = "largefile.txt"; // Use a real 100MB+ file path here
        compareFileReaders(filePath);
    }

    // Part 1: StringBuilder vs StringBuffer
    public static void compareStringBuilderVsStringBuffer() {
        String text = "hello";
        int iterations = 1_000_000;

        // StringBuilder
        long startSB = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endSB = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endSB - startSB) + " ms");

        // StringBuffer
        long startSBuf = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append(text);
        }
        long endSBuf = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endSBuf - startSBuf) + " ms");

        System.out.println();
    }

    // Part 2: FileReader vs InputStreamReader word count comparison
    public static void compareFileReaders(String filePath) {
        System.out.println("Reading file: " + filePath);

        // Using FileReader
        try {
            long startFR = System.currentTimeMillis();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int wordCountFR = countWords(bufferedReader);
            long endFR = System.currentTimeMillis();
            System.out.println("FileReader word count: " + wordCountFR);
            System.out.println("FileReader time: " + (endFR - startFR) + " ms");

        } catch (IOException e) {
            System.out.println("Error using FileReader: " + e.getMessage());
        }

        System.out.println();

        // Using InputStreamReader
        try {
            long startISR = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isReader);

            int wordCountISR = countWords(bufferedReader);
            long endISR = System.currentTimeMillis();
            System.out.println("InputStreamReader word count: " + wordCountISR);
            System.out.println("InputStreamReader time: " + (endISR - startISR) + " ms");

        } catch (IOException e) {
            System.out.println("Error using InputStreamReader: " + e.getMessage());
        }

        System.out.println();
    }

    // Helper method to count words in a file
    private static int countWords(BufferedReader reader) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            wordCount += (line.isBlank() ? 0 : words.length);
        }
        reader.close();
        return wordCount;
    }
}
