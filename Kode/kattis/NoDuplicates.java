package kattis;

import java.util.Scanner;

public class NoDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        boolean dupe = false;
        for (int i=0; i < words.length; i++) {
            for (int j=i+1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    dupe = true;
                    break;
                }
            }
        }
        if (dupe) System.out.println("no");
        else System.out.println("yes");
    }
}
