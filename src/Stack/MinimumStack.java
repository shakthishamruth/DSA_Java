package Stack;

import java.util.Objects;
import java.util.Stack;

public class MinimumStack {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStk = new Stack<>();

    void push(int n) {
        stk.push(n);
        if (minStk.isEmpty()) {
            minStk.push(n);
        } else if (minStk.peek() > n) {
            minStk.push(n);
        }
    }

    void peek() {
        System.out.println(stk.peek());
    }

    void minInt() {
        System.out.println(minStk.peek());
    }

    void pop() {
        if (!stk.isEmpty()) {
            if (Objects.equals(minStk.peek(), stk.peek())) {
                minStk.pop();
                stk.pop();
            } else {
                stk.pop();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
