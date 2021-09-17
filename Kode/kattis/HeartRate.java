package kattis;

import java.util.Locale;
import java.util.Scanner;

public class HeartRate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int n = scanner.nextInt();

        for (int i=0; i < n; i++) {
            //TODO: fullfør
            System.out.printf("%.6g%n",(60*scanner.nextInt())/scanner.nextFloat() );
        }
    }
}
