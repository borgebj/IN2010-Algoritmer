package kattis;

import java.util.Scanner;

public class Planina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        int side = (int) (Math.pow(2, iterations))+1;
        int total = side*side;
        System.out.println(total);
    }
}

// 1. regner ut antall på en side via 2^antall iterasjoner
// legger til en