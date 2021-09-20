package obliger.oblig1;

import algoritmer.AVLTree;

import java.util.*;

public class Kattunge {

    public class Node {
        String innhold;
        Node parent;

        Node(String innhold) {
            this.innhold = innhold;
        }
    }

    public static void finnKattTo(AVLTree.Node v, int x, String path) {
        if (v == null) return;
        else if (v.x == x) {
            path += Integer.toString(x);
            String[] pathList = path.split(" ");
            for (int i=pathList.length-1; i >=0 ;i--) System.out.print(pathList[i]+" ");
        }
        path += v.x+" ";

        finnKattTo(v.left, x, path);
        finnKattTo(v.right, x, path);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // første er kattenode + hashmap for å representere treet
        int katt = scanner.nextInt(); scanner.nextLine();
        AVLTree tre = new AVLTree();

        while(true) {
            int number = scanner.nextInt();
            if (number == -1) break;
            else {
                tre.insert(number);
            }
        }
        tre.print();
        finnKattTo(tre.root, katt, "");
        scanner.close();
    }
}