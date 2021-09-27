package kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OddManOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i=0; i < cases; i++) {
            int guests = scanner.nextInt();

            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int j=0; j < guests; j++) {
                int guest = scanner.nextInt();
                hash.merge(guest, 1, Integer::sum);
            }

            System.out.print("Case #"+(i+1)+": ");
            for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
                if (entry.getValue() == 1) {
                    System.out.print(entry.getKey()+"\n");
                }
            }
        }
    }
}
