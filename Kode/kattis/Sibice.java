package kattis;

import java.util.Scanner;

public class Sibice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NoM = scanner.nextInt();
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        double hypotenus = Math.hypot(width, height);

        for (int i=0; i < NoM; i++) {
            int matchLength = scanner.nextInt();
            if (0 <= matchLength && matchLength <= hypotenus)
                System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
