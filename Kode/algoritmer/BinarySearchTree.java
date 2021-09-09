package algoritmer;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    class Node {
        int x;
        int height;
        Node left;
        Node right;

        Node(int x) {
            this.x = x;
            this.height = 0;
        }
    }

    Node root;

    void insert(int... args) {
        for (int arg : args)
            root = insert(root, arg);
    }
    // støtter ikke duplikater
    Node insert(Node v, int x) {
        if (v == null) {
            return new Node(x);
        }
        else if (x < v.x) {
            v.left = insert(v.left, x);
        }
        else if (x > v.x) {
            v.right = insert(v.right, x);
        }
        return v;
    }

    boolean contains(int x) {
        return contains(root, x);
    }

    void remove(int x) {
        root = remove(root, x);
    }

    Node remove(Node v, int x) {
        if (v == null) {
            return null;
        }
        if (x < v.x) {
            v.left = remove(v.left, x);
            return v;
        }
        if (x > v.x) {
            v.right = remove(v.right, x);
            return v;
        }

        if (v.left == null) {
            return v.right;
        }
        if (v.right == null) {
            return v.left;
        }
        Node u = findMin(v.right);
        v.x = u.x;
        v.right = remove(v.right, u.x);
        return v;
    }

    Node findMin(Node v) {
        if (v == null || v.left == null) {
            return v;
        }
        return findMin(v.left);
    }

    // sjekker om x finnes i treet
    boolean contains(Node v, int x) {
        if (v == null) {
            return false;
        }
        if (x < v.x) {
            return contains(v.left, x);
        }
        if (x > v.x) {
            return contains(v.right, x);
        }
        return true;
    }

    // inorder = i rekkefølge
    void inorder() {
        inorder(root);
    }
    void inorder(Node v) {
        if (v == null) return;
        inorder(v.left);
        System.out.print(v.x+" ");
        inorder(v.right);
    }

    void postorder() {
        postorder(root);
    }
    void postorder(Node v) {
        if (v == null) return;
        System.out.print(v.x+" ");
        postorder(v.left);
        postorder(v.right);
    }

    // broken metode - printer ut et FINT tre https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
    void print() {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<BinarySearchTree.Node> level = new ArrayList<BinarySearchTree.Node>();
        List<BinarySearchTree.Node> next = new ArrayList<BinarySearchTree.Node>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (BinarySearchTree.Node n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = Integer.toString(n.x);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<BinarySearchTree.Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (String f : line) {

                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();

        t.insert(5, 10, 9, 7, 3);
        t.insert(2, 1, 0, -1, 11, 13, 16);

        System.out.println("\n3: "+t.contains(3));
        System.out.println("12: "+t.contains(12));
        System.out.println("7: "+t.contains(7));

        System.out.println("> Fjerner 3 og 7 <");
        t.remove(3);
        t.remove(7);

        System.out.println("3: "+t.contains(3));
        System.out.println("12: "+t.contains(12));
        System.out.println("7: "+t.contains(7));
        System.out.println("---------------------------------");

        System.out.println("Root: "+t.root.x);
        System.out.println("Printer inorder (left-root-right)");
        t.inorder();

        System.out.println("\nPrinter postorder");
        t.postorder();
        System.out.println("\n----------------------------------------------------------------");

        t.print();
        System.out.println("----------------------------------------------------------------");
        System.out.print("add: 12 og 3\n");
        t.insert(12, 3);
        t.print();
        System.out.println("\n----------------------------------------------------------------");
        System.out.print("remove: 5 og 11\n");
        t.remove(5);
        t.remove(11);
        t.print();
        System.out.print("-------------------------------------------------\n\n");
        t.print();
    }
}
