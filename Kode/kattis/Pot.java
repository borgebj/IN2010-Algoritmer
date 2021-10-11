package kattis;

import java.util.Scanner;

public class Pot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();

        int sum = 0;
        for (int i=0; i < lines; i++) {
            int tall = scanner.nextInt();

            sum += Math.pow(tall/10, tall%10);
        }
        System.out.println(sum);
    }
}
