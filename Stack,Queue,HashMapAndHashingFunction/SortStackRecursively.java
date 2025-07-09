import java.util.Stack;

public class SortStackRecursively {

    // Main function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Pop the top element
            int top = stack.pop();

            // Step 2: Recursively sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the popped element in the correct position
            insertInSortedOrder(stack, top);
        }
    }

    // Helper function to insert an element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: stack is empty or element is greater than top
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // Step 1: Remove the top element
        int top = stack.pop();

        // Step 2: Recur until correct position is found
        insertInSortedOrder(stack, element);

        // Step 3: Push the removed item back
        stack.push(top);
    }

    // Display the stack from top to bottom
    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("\nSorted Stack:");
        printStack(stack);
    }
}
