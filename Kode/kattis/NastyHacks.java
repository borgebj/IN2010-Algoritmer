package kattis;

import java.util.Scanner;

public class NastyHacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i < n; i++) {
            int r = scanner.nextInt();
            int e = scanner.nextInt();
            int c = scanner.nextInt();

            int expectedWith = e-c;

            if (r >expectedWith) System.out.println("do not advertise");
            else if (r <expectedWith) System.out.println("advertise");
            else System.out.println("does not matter");
        }
    }
}
