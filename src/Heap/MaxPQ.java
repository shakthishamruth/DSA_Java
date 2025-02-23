package Heap;

import java.util.Scanner;

public class MaxPQ {
    private Integer[] heap;
    private int n;

    MaxPQ(int cap) {
        heap = new Integer[cap + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(int val) {
        if (n == heap.length - 1) {
            // resize
            resize(2 * heap.length);
        }
        n++;
        heap[n] = val;
        swim(n);
    }

    private void resize(int cap) {
        Integer[] temp = new Integer[cap];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private void swim(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            int temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2;
        }
    }

    public void view() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Heap Size:");
        int s = sc.nextInt();
        int val;
        MaxPQ pq = new MaxPQ(s);
        while (running) {
            System.out.println();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Choose: " + "[0.Exit] " + "[1. isEmpty] " + "[2. Size] " + "[3.Insert] ");
            int c = sc.nextInt();
            switch (c) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println(pq.isEmpty());
                    break;
                case 2:
                    System.out.println(pq.size());
                    break;
                case 3:
                    val = sc.nextInt();
                    pq.insert(val);
                    pq.view();
                    break;
                case 4:
                    pq.view();
                    break;
            }
        }
    }
}
