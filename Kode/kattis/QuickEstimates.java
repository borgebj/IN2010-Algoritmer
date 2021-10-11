package kattis;

import java.util.Scanner;

public class QuickEstimates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt(); scanner.nextLine();

        for (int i=0; i < lines; i++) {
            String[] cost = scanner.nextLine().split("");
            System.out.println(cost.length);
        }
    }
}
