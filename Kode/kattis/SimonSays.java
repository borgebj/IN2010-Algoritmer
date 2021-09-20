package kattis;

import java.util.Scanner;

public class SimonSays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt(); scanner.nextLine();

        for (int i=0; i < lines; i++) {
            String word = scanner.nextLine();
            if (word.startsWith("Simon says"))
                System.out.println(word.replace("Simon says", "").trim());
        }
    }
}
