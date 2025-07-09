class MyHashMap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    // Hash function
    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    // Insert or update key-value
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // update
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }

        curr.next = new Node(key, value); // add new
    }

    // Retrieve value by key
    public int get(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1; // not found
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = getIndex(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next; // remove head
                } else {
                    prev.next = curr.next; // remove middle node
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        System.out.println(map.get(2)); // 20
        map.remove(2);
        System.out.println(map.get(2)); // -1 (not found)
        map.put(1, 99);
        System.out.println(map.get(1)); // 99 (updated)
    }
}
