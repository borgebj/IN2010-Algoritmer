package kattis;

import java.util.Scanner;

public class Stopwatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int antpressed = scanner.nextInt();

        boolean running = true;
        int sistTid = scanner.nextInt();
        int stopwatchTime = 0;

        for (int i=1; i < antpressed; i++) {
            int pressed = scanner.nextInt();

            if (!running) {
                running = true;
                sistTid = pressed;
            }
            else {
                running = false;
                stopwatchTime += (pressed-sistTid);
            }
        }
        if (running) System.out.println("still running");
        else System.out.println(stopwatchTime);
    }
}
