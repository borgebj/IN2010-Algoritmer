package kattis;

import java.util.Scanner;

public class BatterUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NoAB = scanner.nextInt();
        int timesAtBat = NoAB;

        double sum = 0;
        for (int i=0; i < NoAB; i++) {
            int action = scanner.nextInt();

            if (action == -1) timesAtBat--;
            else sum += action;
        }
        System.out.println(sum / timesAtBat);
    }
}
