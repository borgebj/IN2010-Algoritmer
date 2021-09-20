package kattis;

import java.util.Scanner;

public class Tarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int megabyteTotal = scanner.nextInt();
        int iterations = scanner.nextInt();

        int total = 0;
        for (int i=0; i < iterations; i++) {
            int megabyteUsage = scanner.nextInt();
            total += megabyteTotal-megabyteUsage;
        }
        System.out.println(total+megabyteTotal);
    }
}
