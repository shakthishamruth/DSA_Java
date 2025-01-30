package LinkedList.DetectLoop;

import java.io.*;
import java.util.*;

public class LoopDetWithHash {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static String isLoop(Node head) {
        if (head == null || head.next == null) {
            return "NO";
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashMap<Integer, Node> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        Node head = null, cur = null;

        for (int i = 0; i < size; i++) {
            int n = sc.nextInt();
            if (map.containsKey(n)) {
                cur.next = map.get(n);
                break;
            }
            Node newNode = new Node(n);

            if (head == null) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }

            map.put(n, cur);
        }

        System.out.print(isLoop(head));
    }
}
