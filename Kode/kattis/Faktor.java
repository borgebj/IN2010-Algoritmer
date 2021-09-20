package kattis;

import java.util.Scanner;

public class Faktor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int i = scanner.nextInt();
        System.out.println( a * (i-1)+1 );
    }
}
