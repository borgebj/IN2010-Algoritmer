package kattis;

import java.util.Scanner;

public class Bijele {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int king = scanner.nextInt();
        int queen = scanner.nextInt();
        int rooks = scanner.nextInt();
        int bishops = scanner.nextInt();
        int knights = scanner.nextInt();
        int pawns = scanner.nextInt();

        System.out.printf("%s ", king > 0 ? 1-king : king+1);
        System.out.printf("%s ", queen > 0 ? 1-queen : queen+1);
        System.out.printf("%s ", rooks > 0 ? 2-rooks : rooks+2);
        System.out.printf("%s ", bishops > 0 ? 2-bishops : bishops+2);
        System.out.printf("%s ", knights > 0 ? 2-knights : knights+2);
        System.out.printf("%s", pawns > 0 ? 8-pawns : pawns+8);
    }
}
