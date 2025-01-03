package LinkedList;

/*
 *
 * NOTE: The linked list starts from head.next
 *
 * */

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
            return;
        }
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

    public static void addFront(int data, Node head) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    public static void addPosition(int data, Node head, int pos) {
        int loop = 1;
        Node temp = head;
        while (pos != loop && temp.next != null) {
            loop++;
            temp = temp.next;
        }
        Node newNode = new Node(data);
        Node temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
    }

    public static void delFirst(Node head) {
        if (head.next == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node temp = head.next;
        temp = temp.next;
        head.next = temp;
    }

    public static void delLast(Node head) {
        if (head.next == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        System.out.println("Last Node with data - " + cur.data + " deleted!");
        prev.next = null;
    }
}

public class SingleLinkList {

    public static void main(String[] args) {
        boolean running = true;
        Node head = new Node();
        Scanner sc = new Scanner(System.in);
        int data;

        while (running) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Choose: " + "[0.Exit] " + "[1. View] " + "[2. Add] " + "[3.Add to Front] ");
            System.out.println("[4. Add to position] " + "[5. Delete 1st Node] " + "[6. Delete at end] ");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    Node.view(head);
                    break;
                case 2:
                    System.out.print("Enter data to add:");
                    data = sc.nextInt();
                    Node.add(data, head);
                    break;
                case 3:
                    System.out.println("Enter data to add in front:");
                    data = sc.nextInt();
                    Node.addFront(data, head);
                    break;
                case 4:
                    System.out.println("Enter POSITION you want to enter the data:");
                    int pos = sc.nextInt();
                    System.out.println("Enter data to add in position " + pos + " :");
                    data = sc.nextInt();
                    Node.addPosition(data, head, pos);
                    break;
                case 5:
                    Node.delFirst(head);
                    break;
                case 6:
                    Node.delLast(head);
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