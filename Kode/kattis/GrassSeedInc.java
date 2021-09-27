package kattis;

import java.util.Locale;
import java.util.Scanner;

public class GrassSeedInc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        double costOfSeeds = scanner.nextDouble();
        double lawns = scanner.nextDouble();

        double totalCost = 0;
        for (int i=0; i < lawns; i++) {
            double sum = scanner.nextDouble()*scanner.nextDouble();
            totalCost += (sum * costOfSeeds);
        }
        System.out.printf("%.8f", totalCost);
    }
}
