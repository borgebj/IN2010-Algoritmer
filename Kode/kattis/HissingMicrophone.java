package kattis;

import java.util.Scanner;

public class HissingMicrophone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] word = scanner.next().split("");

        boolean hiss = false;
        for (int i=0; i<word.length-1; i++) {
            if (word[i].equals(word[i + 1]) && word[i].equals("s")) {
                hiss = true;
                break;
            }
        }
        System.out.printf("%s", hiss ? "hiss" : "no hiss");
    }
}
