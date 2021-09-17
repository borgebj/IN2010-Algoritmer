package kattis;

import java.util.Scanner;

public class NumberFun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i < n; i++) {
            float a = scanner.nextInt();
            float b = scanner.nextInt();
            float c = scanner.nextInt();

            if (a/b == c || b/a == c) System.out.println("Possible");
            else if (a*b == c) System.out.println("Possible");
            else if (a+b == c) System.out.println("Possible");
            else if (a-b == c || b-a == c) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
}
