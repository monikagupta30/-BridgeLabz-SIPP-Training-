import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new text state
    void addState(String content) {
        TextState newState = new TextState(content);

        // If redo states exist after current, discard them
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;
            size++;

            // Limit history to MAX_HISTORY
            if (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }

        System.out.println("New state added.");
    }

    // Undo
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Show current state
    void showCurrent() {
        if (current == null)
            System.out.println("No text yet.");
        else
            System.out.println("Current Text: \"" + current.content + "\"");
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type/Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrent();
                    break;
                case 5:
                    System.out.println("Exiting editor.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
