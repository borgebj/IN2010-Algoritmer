package kattis;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EverywhereMan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j=0; j < t; j++) {
            int iterations = scanner.nextInt(); scanner.nextLine();
            Set<String> cities = new HashSet<>();
            for (int i=0; i < iterations; i++) {
                cities.add(scanner.nextLine());
            }
            System.out.println(cities.size());
        }
    }
}
