package kattis;

import java.util.Scanner;

public class TakeTwoStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int alice=0, bob=0;

        for (int i=1; i <n; i++) {
            if (i%2==0) bob = i;
            else alice = i;
        }
        System.out.printf("%s", Math.min(alice, bob)==alice ? "Alice" : "Bob");
    }
}
