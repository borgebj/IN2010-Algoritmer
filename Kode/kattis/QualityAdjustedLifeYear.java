package kattis;

import java.util.Scanner;


public class QualityAdjustedLifeYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();

        double sum = 0.0;
        for (int i=0; i < lines; i++) {
            System.out.println( scanner.nextInt() );
        }
        System.out.println(sum);
    }
}
