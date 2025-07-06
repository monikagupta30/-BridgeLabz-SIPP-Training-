import java.util.Scanner;

class TaskNode {
    int id;
    String name;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    TaskNode head = null;
    TaskNode current = null;

    // Add at beginning
    void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning.");
    }

    // Add at end
    void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println("Task added at end.");
    }

    // Add at specific position (1-based)
    void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Task added at position " + position);
    }

    // Remove by Task ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head, prev = null;

        // Case: only one node
        if (head.next == head && head.id == id) {
            head = null;
            current = null;
            System.out.println("Task removed.");
            return;
        }

        // Case: head node to be deleted
        if (head.id == id) {
            TaskNode last = head;
            while (last.next != head)
                last = last.next;
            head = head.next;
            last.next = head;
            current = head;
            System.out.println("Task removed.");
            return;
        }

        // General case
        do {
            prev = temp;
            temp = temp.next;
            if (temp.id == id) {
                prev.next = temp.next;
                if (current == temp)
                    current = current.next;
                System.out.println("Task removed.");
                return;
            }
        } while (temp != head);

        System.out.println("Task with ID " + id + " not found.");
    }

    // View current task and move to next
    void viewCurrentAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("--- Task List ---");
        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No task found with priority: " + priority);
    }

    // Display a task
    void displayTask(TaskNode node) {
        System.out.println("ID: " + node.id + ", Name: " + node.name + ", Priority: " + node.priority + ", Due Date: " + node.dueDate);
    }
}

public class CircularTaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        int choice;
        do {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, pos, priority;
            String name, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); name = sc.nextLine();
                    System.out.print("Enter Priority: "); priority = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Due Date: "); dueDate = sc.nextLine();
                    scheduler.addAtBeginning(id, name, priority, dueDate);
                    break;
                case 2:
                    System.out.print("Enter Task ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); name = sc.nextLine();
                    System.out.print("Enter Priority: "); priority = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Due Date: "); dueDate = sc.nextLine();
                    scheduler.addAtEnd(id, name, priority, dueDate);
                    break;
                case 3:
                    System.out.print("Enter Position: "); pos = sc.nextInt();
                    System.out.print("Enter Task ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); name = sc.nextLine();
                    System.out.print("Enter Priority: "); priority = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Due Date: "); dueDate = sc.nextLine();
                    scheduler.addAtPosition(pos, id, name, priority, dueDate);
                    break;
                case 4:
                    System.out.print("Enter Task ID to Remove: "); id = sc.nextInt();
                    scheduler.removeById(id);
                    break;
                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;
                case 6:
                    scheduler.displayAllTasks();
                    break;
                case 7:
                    System.out.print("Enter Priority to Search: "); priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;
                case 8:
                    System.out.println("Exiting Task Scheduler.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
