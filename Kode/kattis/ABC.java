package kattis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.nextLine();
        String order = scanner.nextLine();

        for (String s : order.split("")) {
            switch (s.toLowerCase()) {
                case "a":
                    System.out.println(Math.min(Math.min(x, y), z));
                    break;
                case "b":
                    System.out.println(Math.max(Math.min(x, y), Math.min(Math.max(x, y), z)));
                    break;
                case "c":
                    System.out.println(Math.max(Math.max(x, y), z));
                    break;
            }
        }
    }
}
