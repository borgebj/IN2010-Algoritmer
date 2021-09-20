package kattis;

import java.util.Scanner;

public class Spavanac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int timeDiff = minute-=45;

        if (timeDiff<0) hour--;
        if (minute<0) minute+=60;
        if (hour<0) hour+= 24;

        System.out.println(hour+" "+minute);
    }
}
