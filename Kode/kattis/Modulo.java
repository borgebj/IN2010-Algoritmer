package kattis;

import java.util.*;

public class Modulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        for (int i=0; i < 10; i++) {
            int n = scanner.nextInt();
            set.add(n % 42);
        }
        System.out.println(set.size());
    }
}
