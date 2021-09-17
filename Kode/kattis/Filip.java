package kattis;

import java.util.Scanner;

public class Filip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = String.valueOf(scanner.nextInt());
        String b = String.valueOf(scanner.nextInt());
        String reverseA = "";
        String reverseB = "";
        for (int i=a.length()-1; i >= 0; i--) reverseA += a.charAt(i);
        for (int j=b.length()-1; j >= 0; j--) reverseB += b.charAt(j);
        System.out.printf("%s", Integer.parseInt(reverseA) > Integer.parseInt(reverseB) ? reverseA : reverseB);
    }
}
