package kattis;

import java.util.Scanner;

public class Aaah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jon = scanner.nextLine();
        String doctor = scanner.nextLine();

        if (jon.length() >= doctor.length()) System.out.println("go");
        else if (jon.length() < doctor.length()) System.out.println("no");
    }
}
