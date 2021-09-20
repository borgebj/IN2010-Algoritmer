package kattis;

import java.util.Scanner;

public class SevenWonders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = 0;
        int c = 0;
        int g = 0;

        String[] builings = scanner.next().split("");
        for (String builing : builings) {
            switch (builing) {
                case "T":
                    t++;
                    break;
                case "C":
                    c++;
                    break;
                case "G":
                    g++;
                    break;
            }
        }
        int sum = (int) (Math.pow(t, 2)+Math.pow(c, 2)+Math.pow(g, 2));
        int bonus = 0;
        if (t>0 && c>0 && g>0) bonus += 7* Math.min(Math.min(t, c), g);
        System.out.println(sum+bonus);
    }
}
