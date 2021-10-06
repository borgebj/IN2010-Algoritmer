package kattis;

import java.util.HashMap;
import java.util.Scanner;

public class KittenOnATree {

    static HashMap<String, String> opprettTre(Scanner scanner) {
        HashMap<String, String> tre = new HashMap<>();

        while (true) {
            String parent = scanner.next();

            // stopper om -1
            if (parent.equals("-1")) break;
            else {
                String[] nums = scanner.nextLine().split(" ");

                // parent = key, resten av linjen er childnoder
                for (String num : nums) tre.put(num, parent);
            }
        }
        return tre;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String katt = scanner.next(); scanner.nextLine();

        HashMap<String, String> tre = opprettTre(scanner);

        // sjekker om treet inneholder katt - endrer til valuen som katt holder
        System.out.print(katt+" ");
        while (tre.containsKey(katt)) {
            katt = tre.get(katt);
            System.out.print(katt+" ");
        }
    }
}