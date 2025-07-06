import java.util.*;

class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    ProcessNode head = null;
    ProcessNode tail = null;

    void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = newNode;
            head.next = head;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        System.out.println("Process " + pid + " added.");
    }

    void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode curr = head, prev = tail;

        do {
            if (curr.pid == pid) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    boolean isEmpty() {
        return head == null;
    }

    void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        List<ProcessNode> completedProcesses = new ArrayList<>();
        Map<Integer, Integer> finishTimes = new HashMap<>();
        Map<Integer, Integer> waitingTimes = new HashMap<>();
        int currentTime = 0;

        ProcessNode curr = head;

        while (!isEmpty()) {
            displayQueue();

            if (curr.remainingTime > 0) {
                int timeUsed = Math.min(curr.remainingTime, timeQuantum);
                curr.remainingTime -= timeUsed;
                currentTime += timeUsed;

                // Update waiting times for others
                ProcessNode temp = curr.next;
                while (temp != curr) {
                    if (temp.remainingTime > 0) {
                        temp.waitingTime += timeUsed;
                    }
                    temp = temp.next;
                }

                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = currentTime;
                    finishTimes.put(curr.pid, currentTime);
                    waitingTimes.put(curr.pid, curr.turnaroundTime - curr.burstTime);
                    completedProcesses.add(curr);
                    removeProcess(curr.pid);
                    curr = curr == tail ? head : curr.next;
                    continue;
                }
            }

            curr = curr.next;
        }

        // Output stats
        System.out.println("\nAll processes completed.\n");
        System.out.println("PID\tBT\tWT\tTAT");
        double totalWT = 0, totalTAT = 0;
        for (ProcessNode p : completedProcesses) {
            int wt = waitingTimes.get(p.pid);
            int tat = finishTimes.get(p.pid);
            totalWT += wt;
            totalTAT += tat;
            System.out.println(p.pid + "\t" + p.burstTime + "\t" + wt + "\t" + tat);
        }

        int n = completedProcesses.size();
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / n);
    }

    void displayQueue() {
        if (head == null) return;

        System.out.println("Processes in Queue:");
        ProcessNode temp = head;
        do {
            System.out.println("PID: " + temp.pid + ", BT: " + temp.burstTime + ", RT: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class RoundRobinCPU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        int choice;
        do {
            System.out.println("\n--- Round Robin Scheduler Menu ---");
            System.out.println("1. Add Process");
            System.out.println("2. Simulate Scheduling");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int pid, bt, priority, tq;

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: "); pid = sc.nextInt();
                    System.out.print("Enter Burst Time: "); bt = sc.nextInt();
                    System.out.print("Enter Priority: "); priority = sc.nextInt();
                    scheduler.addProcess(pid, bt, priority);
                    break;
                case 2:
                    System.out.print("Enter Time Quantum: ");
                    tq = sc.nextInt();
                    scheduler.simulate(tq);
                    break;
                case 3:
                    System.out.println("Exiting Scheduler.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}
