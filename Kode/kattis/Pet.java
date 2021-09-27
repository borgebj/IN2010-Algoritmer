package kattis;

import java.util.Arrays;
import java.util.Scanner;

public class Pet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int winningNr = 0;
        int winningSum = 0;
        for (int i=1; i <= 5; i++) {
            int sum = 0;

            for (int j=0; j < 4; j++) sum += scanner.nextInt();
            if (sum > winningSum) {
                winningSum = sum;
                winningNr = i;
            }
        }
        System.out.println(winningNr+" "+winningSum);
    }
}
