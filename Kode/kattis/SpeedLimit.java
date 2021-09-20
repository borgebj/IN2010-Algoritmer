package kattis;

import java.util.Scanner;

public class SpeedLimit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ant = scanner.nextInt();
        while (ant != -1) {
            int mph = 0;
            int time = 0;

            for (int i = 0; i < ant; i++) {
                int miles = scanner.nextInt();
                int elapsed = scanner.nextInt();

                mph += miles * (elapsed - time);
                time = elapsed;
            }
            System.out.println(mph + " miles");
            ant = scanner.nextInt();
        }
    }
}
