package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MinimumStack {
    static Stack<Integer> stk = new Stack<>();
    static Stack<Integer> minStk = new Stack<>();

    static void push(int n) {
        stk.push(n);
        if (minStk.isEmpty() || minStk.peek() >= n) {
            minStk.push(n);
        }
        System.out.println("Number Inserted: " + n);
    }

    static void peek() {
        if (stk.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Top most element: " + stk.peek());
    }

    static void getMin() {
        if (minStk.isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Minimum element: " + minStk.peek());
        }
    }

    static void pop() {
        if (stk.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        int t = stk.pop();
        System.out.println("Removed element: " + t);

        if (t == minStk.peek()) {
            minStk.pop();
        }
    }

    public static void main(String[] args) {
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        while (running) {
            System.out.println("----------------------------------------------------");
            System.out.println("[0.exit] [1. push] [2.peek] [3.pop] [4.getMin]");
            int ch = sc.nextInt();
            switch (ch) {
                case 0:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                case 1:
                    System.out.print("Enter the int to push: ");
                    int in = sc.nextInt();
                    push(in);
                    break;
                case 2:
                    peek();
                    break;
                case 3:
                    pop();
                    break;
                case 4:
                    getMin();
                    break;
                default:
                    System.out.println("Wrong choice try again!");
                    break;
            }
        }
        sc.close();
    }
}
