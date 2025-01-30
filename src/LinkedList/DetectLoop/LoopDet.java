package LinkedList.DetectLoop;

import java.util.Scanner;

public class LoopDet {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static boolean isLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int cycPos = sc.nextInt();
        Node head = null, cur = null, NodeCyc = null;

        System.out.println("------------");

        for (int i = 0; i < size; i++) {
            int n = sc.nextInt();
            Node newNode = new Node(n);

            if (head == null) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }

            if (i == cycPos) {
                NodeCyc = cur;
            }
        }

        if (cycPos != -1 && NodeCyc != null) {
            cur.next = NodeCyc;
        }

        System.out.println(isLoop(head));

    }
}
