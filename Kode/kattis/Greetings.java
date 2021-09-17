package kattis;

import java.util.Arrays;
import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int antalLE = 0;
        String originaltext = scanner.next();
        String[] hey = originaltext.split("");
        StringBuilder finalText = new StringBuilder(originaltext);
        for (String s : hey) if (s.equals("e")) antalLE++;
        for (int i=0; i < antalLE; i++) finalText.insert(2, "e");
        System.out.println(finalText);
    }
}
