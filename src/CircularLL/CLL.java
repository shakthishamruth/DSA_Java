package CircularLL;


import java.util.Scanner;

public class CLL {

    private Node last;
    private int len;

    private class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CLL() {
        last = null;
        len = 0;
    }

    public int length() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        last = newNode;
        len++;
    }

    public void display() {
        if (isEmpty() && last == null) {
            System.out.println("CLL is empty");
            return;
        }
        Node temp = last.next;
        while (temp != last) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    public void insertFront(int val) {
        Node newNode = new Node(val);
        if (isEmpty() && last == null) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        len++;
    }

    public void delFront() {
        if (isEmpty() && last == null) {
            System.out.println("CLL is empty");
            return;
        }
        Node temp = last.next;
        if (temp == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        System.out.println(temp.data + " is deleted");
        len--;
    }

    public static void main(String[] args) {
        CLL cll = new CLL();
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int val;

        while (running) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Options: [0. Exit] [1. Insert Last] [2. Insert Front] [3. Display] [4. Del at Front]");
            int ch = sc.nextInt();
            switch (ch) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.print("Enter val to insert at last: ");
                    val = sc.nextInt();
                    cll.insert(val);
                    break;
                case 2:
                    System.out.print("Enter val to insert at front: ");
                    val = sc.nextInt();
                    cll.insertFront(val);
                    break;
                case 3:
                    cll.display();
                    break;
                case 4:
                    cll.delFront();
                    break;
                default:
                    System.out.println("Wrong option try again");
                    break;
            }
        }
        sc.close();
    }
}
