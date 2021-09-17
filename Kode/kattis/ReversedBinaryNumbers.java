package kattis;

import java.util.Scanner;

public class ReversedBinaryNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // innebygd måte
        String binary = Integer.toBinaryString(scanner.nextInt());
        String reversebinary = new StringBuilder(binary).reverse().toString();
        System.out.println(Integer.parseInt(reversebinary, 2));
    }
}
