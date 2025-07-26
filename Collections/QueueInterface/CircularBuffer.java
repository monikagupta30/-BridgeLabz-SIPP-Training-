import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;
    private int end = 0;
    private boolean isFull = false;

    public CircularBuffer(int capacity) {
        this.size = capacity;
        this.buffer = new int[capacity];
    }

    // Add an element (overwrite if full)
    public void add(int value) {
        buffer[end] = value;
        end = (end + 1) % size;

        if (isFull) {
            start = (start + 1) % size; // Overwrite oldest
        }

        if (end == start) {
            isFull = true;
        }
    }

    // Get current buffer as list in correct order
    public int[] getBuffer() {
        int[] result = new int[isFull ? size : (end >= start ? end - start : size - start + end)];
        for (int i = 0, idx = start; i < result.length; i++) {
            result[i] = buffer[idx];
            idx = (idx + 1) % size;
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [1, 2, 3]
        cb.add(4);
        System.out.println("Buffer after adding 4: " + Arrays.toString(cb.getBuffer())); // [2, 3, 4]
    }
}
