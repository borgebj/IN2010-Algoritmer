package kattis;

import java.util.Scanner;

public class ADifferentProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a, b;
        while (scanner.hasNextLong()) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            System.out.printf("%d\n", b < a ? a-b : b-a);
        }
    }
}
