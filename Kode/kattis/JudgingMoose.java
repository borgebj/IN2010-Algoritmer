package kattis;

import java.util.Scanner;

public class JudgingMoose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        int highest = Math.max(left, right);
        int lowest = Math.min(left, right);
        int diff = highest-lowest;

        if (left==0 && right==0) System.out.println("Not a moose");
        else {
            if (left - right != 0) System.out.print("Odd");
            else System.out.print("even");
            System.out.print(" " + (highest + lowest + diff));
        }
    }
}
