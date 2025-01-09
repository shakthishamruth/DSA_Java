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
            System.out.println("Linked list is empty!");
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

    public static void delPos(Node head, int pos) {
        if (head.next == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node prev = head;
        Node cur = head.next;
        int c = 0;
        while (pos != c && cur.next != null) {
            prev = cur;
            cur = cur.next;
            c++;
        }
        prev.next = cur.next;
        System.out.println("Node on position " + pos + " is deleted with data " + cur.data);
        cur.next = null;
    }

    public static void search(Node head, int data) {
        if (head.next == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node temp = head.next;
        int c = 0;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("The element is found at position: " + c + " !");
                return;
            }
            temp = temp.next;
            c++;
        }
        System.out.println("The element " + data + " is not found in the linked list!");
    }

    public static void reverse(Node head) {
        if (head.next == null) {
            return;
        }
        Node current = head.next;
        Node next = null;
        Node prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = prev;
    }

    public static void nthElement(Node head, int n) {
        if (head.next == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        int c = 0;
        Node temp = head.next;
        Node main = head.next;
        while (c < n && temp != null) {
            temp = temp.next;
            c++;
        }
        if (temp == null) {
            System.out.println("The element on first from END is " + main.data);
            return;
        }
        while (temp != null) {
            temp = temp.next;
            main = main.next;
        }
        System.out.println("The element on " + n + " from END is " + main.data);
    }
}

public class SingleLinkList {

    public static void main(String[] args) {
        boolean running = true;
        Node head = new Node();
        Scanner sc = new Scanner(System.in);
        int data;
        int pos;
        while (running) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Choose: " + "[0.Exit] " + "[1. View] " + "[2. Add] " + "[3.Add to Front] ");
            System.out.println("[4. Add to position] " + "[5. Delete 1st Node] " + "[6. Delete at end] ");
            System.out.println("[7. Delete Node at position] [8. Search] [9. Reverse] ");
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
                    pos = sc.nextInt();
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
                case 7:
                    System.out.println("Enter POSITION you want to delete the Node:");
                    pos = sc.nextInt();
                    Node.delPos(head, pos);
                    break;
                case 8:
                    System.out.println("Enter the element you want to search: ");
                    data = sc.nextInt();
                    Node.search(head, data);
                    break;
                case 9:
                    Node.reverse(head);
                    System.out.println("Reversing complete!");
                    break;
                case 10:
                    System.out.println("Enter the POSITION from END to see:");
                    pos = sc.nextInt();
                    Node.nthElement(head, pos);
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