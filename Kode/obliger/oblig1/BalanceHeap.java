package obliger.oblig1;


import java.util.ArrayList;
import java.util.Scanner;


public class BalanceHeap {

    // metoden starten fra midten - går deretter mot høyre, og så til venstre
    public static void printAsTree(ArrayList<Integer> arr, int first, int last) {
        if ( first > last) return;

        // midtre indeks og midtre tall
        int midten = (first+last)/2;
        int midtTall = arr.get(midten);

        System.out.println(midtTall);

        // rekursjerer høyre-siden av arrayet først, så venstre
        printAsTree(arr, midten+1, last);
        printAsTree(arr, first, midten-1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i=0; i <= 10; i++) {
            arr.add(scanner.nextInt());
        }

        printAsTree(arr, 0, arr.size()-1);
    }
}
