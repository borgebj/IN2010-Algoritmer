package kattis;

import java.util.Scanner;

public class Apaxiaaans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] word = scanner.next().split("");

        for (int i=0; i < word.length-1; i++) {
            if (!word[i].equals(word[i+1])) System.out.print(word[i]);
        }
        System.out.println(word[word.length-1]);
    }
}
