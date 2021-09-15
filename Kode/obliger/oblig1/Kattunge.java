package obliger.oblig1;

import sun.security.util.ArrayUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kattunge {

    private static Node root;

    // bruker en enkel tree-datastruktur for å opprette treet med kun parent-peker
    static class Node {
        int x;
        Node parent;

        Node(int x) {
            this.x = x;
        }
    }

    // henter noden som inneholder element x
/*    static Node get(int x) {
        return;
    }*/


    static void findExit(int x) {
        findExit(root, x);
    }
    static void findExit(Node v, int x) {

    }


    public static void main(String[] args) throws FileNotFoundException {
        File fil = new File(args[0]);
        Scanner scanner = new Scanner(fil);

        // henter kattenoden - første tall
        int katteNode = scanner.nextInt(); scanner.nextLine();

        // sjekker alle linjer med counter
        for (int lineNum=1; scanner.hasNextLine(); lineNum++) {
            String[] line = scanner.nextLine().trim().split(" ");
            if (line[0].equals("-1")) break;

            if (lineNum == 1) // første linje etter katten = rot-linjen + sine barn
            {
                root = new Node(Integer.parseInt(line[0]));
                System.out.print("\nRoot: "+root.x);
                System.out.print("\nbarn: ");
                for (int b=1; b < line.length; b++) {
                    Node barn = new Node(Integer.parseInt(line[b]));
                    barn.parent = root;
                    System.out.print(barn.x + " ");
                }
            }
            else  // ellers lag vanlige noder med foreldre-peker
            {
                Node parent = new Node(Integer.parseInt(line[0]));
                System.out.print("\n\nparent: "+parent.x);
                System.out.print("\nbarn: ");
                for (int a = 1; a < line.length; a++) {
                    Node barn = new Node(Integer.parseInt(line[a]));
                    barn.parent = parent;
                    System.out.print(barn.x + " ");
                }
            }
        }
    }
}
