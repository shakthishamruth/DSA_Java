package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.next = null;
    }
}

public class SingleLinkList {

    public static void main(String[] args) {
        boolean running = true;
        Node head = new Node();
        Scanner sc = new Scanner(System.in);
        Node temp;

        while (running) {
            System.out.println("--------------------------------------");
            System.out.println("Choose: " + "[1. View] " + "[2. Add] ");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    if (head.next == null) {
                        System.out.println("List is empty!");
                    } else {
                        System.out.print("List: ");
                        temp = head.next;
                        int count = 0;
                        while (temp != null) {
                            System.out.print(temp.data + " → ");
                            count++;
                            temp = temp.next;
                        }
                        System.out.println("null");
                        System.out.printf("Size of Linked List: %d \n", count);
                    }
                    break;
                case 2:
                    System.out.print("Enter data to add:");
                    int data = sc.nextInt();
                    Node newNode = new Node(data);
                    temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newNode;
                    break;
                case 0:
                    System.out.println("Exiting...");
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}