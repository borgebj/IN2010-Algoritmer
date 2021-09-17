package kattis;

import java.util.Scanner;

public class LastFactorialDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i=0; i < testCases; i++) {
            int num = scanner.nextInt();
            int factorial = 1;
            for (int j=1; j <= num; j++) {
                factorial = factorial*j;
            }
            System.out.println(factorial%10);
        }
    }
}
