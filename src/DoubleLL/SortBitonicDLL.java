package DoubleLL;


import java.io.*;
import java.util.*;

public class SortBitonicDLL {

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node first = head;
        Node last = head;
        Node res = new Node(0);
        Node resEnd = res;
        Node temp;

        while (last.next != null) {
            last = last.next;
        }

        while (first != last) {
            if (first.val <= last.val) {
                resEnd.next = first;
                temp = first.next;
                first.next = null;
                first.prev = resEnd;
                first = temp;
                resEnd = resEnd.next;
            } else {
                resEnd.next = last;
                temp = last.prev;
                last.prev.next = null;
                last.prev = resEnd;
                resEnd.next = last;
                last = temp;
                resEnd = resEnd.next;
            }
        }

        resEnd.next = first;
        first.prev = resEnd;

        return res.next;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            boolean running = true;
            Node head = null, cur = null;
            while (running) {
                int n = sc.nextInt();
                if (n == -1) {
                    running = false;
                    break;
                }
                Node newNode = new Node(n);
                if (head == null) {
                    head = newNode;
                    cur = head;
                } else {
                    cur.next = newNode;
                    newNode.prev = cur;
                    cur = cur.next;
                }
            }
            head = sort(head);
            print(head);
            System.out.println();
        }
    }
}
