package kattis;

import java.util.Locale;
import java.util.Scanner;

public class QualityAdjustedLifeYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int lines = scanner.nextInt();

        double sum = 0;
        for (int i=0; i < lines; i++) {
            sum += (scanner.nextDouble() * scanner.nextDouble());
        }
        System.out.printf("%.3f", sum);
    }
}
