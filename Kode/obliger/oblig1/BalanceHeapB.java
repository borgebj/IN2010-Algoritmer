package obliger.oblig1;

import java.util.PriorityQueue;
import java.util.Scanner;


public class BalanceHeapB {

    public static void printHeapAsTree(PriorityQueue<Integer> heap) {
        PriorityQueue<Integer> left = new PriorityQueue<>();

        int midten = (heap.size())/2;

        // legger venstre-halvdel i venstre-listen
        for (int i=0; i < midten; i++) {
            left.offer(heap.poll());
        }

        if (heap.size() !=0) System.out.println(heap.poll());

        if (heap.size() > 0 || left.size() > 0) {
            printHeapAsTree(heap);
            printHeapAsTree(left);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i <= 10; i++) {
            heap.offer(scanner.nextInt());
        }
        printHeapAsTree(heap);
    }
}
