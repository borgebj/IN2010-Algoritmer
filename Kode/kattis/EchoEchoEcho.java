package kattis;

import java.util.Scanner;

public class EchoEchoEcho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println(new String(new char[3]).replace("\0", word+" "));
    }
}

// nvm dette var den enkleste, wtf??