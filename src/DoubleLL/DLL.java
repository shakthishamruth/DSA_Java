package DoubleLL;

import java.util.Scanner;

public class DLL {

    private Node head;
    private Node tail;
    private int len;

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int val) {
            this.data = val;
            this.next = null;
            this.prev = null;
        }

        public int length() {
            return len;
        }
    }

    public DLL() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        len++;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;
        len++;
    }


    public void displayForward() {
        if (head == null) {
            System.out.println("DLL is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("DLL is empty!");
            return;
        }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.prev;
        }
        System.out.print("null");
    }


    public static void main(String[] args) {
        DLL dll = new DLL();
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        int val;

        while (running) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Options: [0. Exit] [1. Display Forward] [2. Display Backward] [3. Insert Last] [4. Insert Front]");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 0:
                    running = false;
                    break;
                case 1:
                    dll.displayForward();
                    break;
                case 2:
                    dll.displayBackward();
                    break;
                case 3:
                    val = sc.nextInt();
                    dll.insertLast(val);
                    System.out.println("Added " + val + " at last");
                    break;
                case 4:
                    val = sc.nextInt();
                    dll.insertFirst(val);
                    System.out.println("Added " + val + " at front");
                    break;
                default:
                    System.out.println("Wrong option try again!");
                    break;
            }
        }

        sc.close();
    }
}
