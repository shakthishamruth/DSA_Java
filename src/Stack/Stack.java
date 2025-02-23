package Stack;

public class Stack {
    // LIFO
    private Node top;
    private int len;

    private class Node {
        private int data;
        private Node next;

        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        len = 0;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int length() {
        return len;
    }

    // push in front
    public void push(int val) {
        Node temp = new Node(val);
        temp.next = top;
        top = temp;
        len++;
    }

    // pop in front first come last out
    public int pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!");
            return -1;
        }
        int res = top.data;
        System.out.println(top.data + " is pop-ed");
        top = top.next;
        len--;
        return res;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!");
            return -1;
        }
        return top.data;
    }

}
