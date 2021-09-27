package kattis;

import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        double v = scanner.nextInt();
        double radian = v * (Math.PI / 180);
        int result = (int) Math.ceil( h / Math.sin(radian) );

        System.out.println( result );
    }
}
// Math.ceil(x)
// - runder opp desimal X

/**
 1. Gjøre 'v' (grader) om til radian
 - x * ( pi / 180 )
 2. dele "opposite" med sinus(radian)
 > x / Sine(x*(pi/180))
 **/