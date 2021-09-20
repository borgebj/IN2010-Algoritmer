package kattis;

import java.util.*;

public class ColdPuterScience {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        List<Integer> temperaturs = new ArrayList<>();

        for (int i=0; i<days; i++) {
            int temp = scanner.nextInt();
            if (temp<0) temperaturs.add(temp);
        }
        System.out.println(temperaturs.size());
    }
}
