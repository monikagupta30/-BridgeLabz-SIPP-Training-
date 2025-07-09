import java.util.Stack;

public class StockSpanProblem {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop indices from stack while the current price is greater or equal
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // If stack is empty, all previous prices are smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);

        System.out.println("Stock Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        System.out.println("\nStock Spans: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
