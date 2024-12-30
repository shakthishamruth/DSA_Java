package LinkedList;

import java.util.Scanner;

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.next = null;
    }

    public static void add(int data, Node head) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void view(Node head) {
        if (head.next == null) {
            System.out.println("List is empty!");
        } else {
            System.out.print("List: ");
            Node temp = head.next;
            int count = 0;
            while (temp != null) {
                System.out.print(temp.data + " → ");
                count++;
                temp = temp.next;
            }
            System.out.println("null");
            System.out.printf("Size of Linked List: %d \n", count);
        }
    }
}

public class SingleLinkList {

    public static void main(String[] args) {
        boolean running = true;
        Node head = new Node();
        Scanner sc = new Scanner(System.in);

        while (running) {
            System.out.println("--------------------------------------");
            System.out.println("Choose: " + "[1. View] " + "[2. Add] ");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    Node.view(head);
                    break;
                case 2:
                    System.out.print("Enter data to add:");
                    int data = sc.nextInt();
                    Node.add(data, head);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect Option Try Again!");
                    break;
            }
        }
        sc.close();
    }
}