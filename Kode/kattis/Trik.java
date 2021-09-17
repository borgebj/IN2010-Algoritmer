package kattis;

import java.util.Scanner;

public class Trik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = scanner.nextLine().split("");
        String[] cups = {"ball", "x", "x"};

        String temp;
        for(String s : moves) {
            switch(s) {
                case "A":
                    temp = cups[0];
                    cups[0] = cups[1];
                    cups[1] = temp;
                    break;
                case "B":
                    temp = cups[1];
                    cups[1] = cups[2];
                    cups[2] = temp;
                    break;
                case "C":
                    temp = cups[0];
                    cups[0] = cups[2];
                    cups[2] = temp;
                    break;
            }
        }
        for (int i=0; i < 3; i++) if (cups[i].equals("ball")) System.out.println(i+1);
    }
}
