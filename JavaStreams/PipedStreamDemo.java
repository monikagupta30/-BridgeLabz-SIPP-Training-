import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) throws IOException {
        // Create piped input and output streams
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos); // Connect streams

        // Create writer and reader threads
        Thread writerThread = new Thread(new Writer(pos), "WriterThread");
        Thread readerThread = new Thread(new Reader(pis), "ReaderThread");

        // Start both threads
        writerThread.start();
        readerThread.start();
    }

    // Writer class writes data to the PipedOutputStream
    static class Writer implements Runnable {
        private final PipedOutputStream pos;

        public Writer(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                String[] messages = {
                    "Hello from writer!",
                    "This is piped stream communication.",
                    "Java multithreading is powerful.",
                    "End"
                };

                for (String msg : messages) {
                    writer.write(msg);
                    writer.newLine();
                    writer.flush(); // Ensure data is pushed
                    Thread.sleep(500); // Simulate delay
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Writer error: " + e.getMessage());
            }
        }
    }

    // Reader class reads data from the PipedInputStream
    static class Reader implements Runnable {
        private final PipedInputStream pis;

        public Reader(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Reader received: " + line);
                    if (line.equals("End")) break;
                }
            } catch (IOException e) {
                System.out.println("Reader error: " + e.getMessage());
            }
        }
    }
}
