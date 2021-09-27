package kattis;

import java.util.Scanner;

public class MixedFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            if (numerator == 0 && denominator == 0) break;

            int quotient = numerator/denominator;
            int remainder = numerator%denominator;

            System.out.println(quotient+" "+remainder+" / "+denominator);

        }
    }
}
// https://www.cuemath.com/questions/how-to-change-an-improper-fraction-into-a-mixed-number/
/**
 * Explanation:

 Convert 23/4 into a mixed fraction.

 1. First, divide the numerator by the denominator: 23 ÷ 4 = 5 . Here, 5 is the quotient, and 3 is the remainder.
 2. Write down 5 as the whole number and the remainder (3) as the new numerator on the same old denominator (4).
 3.  So, 23/4 converted into a mixed fraction will be    3 4 / 5

 * */
