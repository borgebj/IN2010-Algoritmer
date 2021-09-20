package kattis;

import java.util.Scanner;

public class Autori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] words = scanner.next().split("-");

        StringBuilder finalstring = new StringBuilder();
        for (String word : words) {
            finalstring.append(word.charAt(0));
        }
        System.out.println(finalstring);
    }
}
