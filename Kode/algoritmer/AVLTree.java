package algoritmer;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    public class Node {
        public int x;
        public int height;
        public Node left;
        public Node right;

        Node(int x) {
            this.x = x;
            this.height = 0;
        }
    }

    // første element - roten til treet / starten
    public Node root;



    /** rotasjoner **/
    Node leftRotate(Node z) {
        Node y = z.right;
        Node t1 = y.left;

        y.left = z;
        z.right = t1;

        z.height = 1 + Math.max( height(z.left), height(z.right) );
        y.height = 1 + Math.max( height(y.left), height(y.right) );

        return y;
    }

    Node rightRotate(Node z) {
        Node y = z.left;
        Node t2 = y.right;

        y.right = z;
        z.left = t2;

        z.height = 1 + Math.max( height(z.left), height(z.right) );
        y.height = 1 + Math.max( height(y.left), height(y.right) );

        return y;
    }

    /** balansering **/
    // positivt = venstretung - høyrerotasjon
    // negativt = høyretung - venstrerotasjon
    int balanceFactor(Node v) {
        if (v == null)
            return 0;
        return (height(v.left) - height(v.right));
    }

    Node balance(Node v) {
        // høyretung
        if (balanceFactor(v) < -1) {
            if (balanceFactor(v.right) > 0)
                v.right = rightRotate(v.right);
            return leftRotate(v);
        }

        // venstretung
        if (balanceFactor(v) > 1) {
            if (balanceFactor(v.left) < 0)
                v.left = leftRotate(v.left);
            return rightRotate(v);
        }
        return v;
    }

    /** balance-insert **/// støtter inserting av 1 eller flere
    public void insert(int... args) {
        for (int arg : args)
            root = insert(root, arg);
    }
    Node insert(Node v, int x) {
        if (v == null)
            v =  new Node(x);

        else if (x < v.x)
            v.left = insert(v.left, x);

        else if (x > v.x)
            v.right = insert(v.right, x);

        v.height = 1 + Math.max( height(v.left), height(v.right) );
        return balance(v);
    }


    /** balance-remove **/
    public void remove(int x) {
        root = remove(root, x);
    }
    Node remove(Node v, int x) {
        if (v == null)
            return null;

        if (x < v.x)
            v.left = remove(v.left, x);

        else if (x > v.x)
            v.right = remove(v.right, x);

        // case 2: har kun 1-barnenode
        else if (v.left == null)
            v = v.right;

        else if (v.right == null)
            v = v.left;

        // case 3: har begge barnenoder
        else {
            Node u = findMin(v.right);
            v.x = u.x;
            v.right = remove(v.right, u.x);
            v.height = 1 + Math.max( height(v.left), height(v.right) );
        }
        return balance(v);
    }
    // det står her i forelesningen, men ↑ fungerer, ikke ↓. Spør?
    //v.height = 1 + Math.max( height(v.left), height(v.right) );


    /** contains**/
    public boolean contains(int x) {
        return contains(root, x);
    }
    // sjekker om x finnes i treet
    boolean contains(Node v, int x) {
        if (v == null)
            return false;

        if (x < v.x)
            return contains(v.left, x);

        if (x > v.x)
            return contains(v.right, x);

        return true;
    }

    /** inorder**/
    // inorder = i rekkefølge - minst til størst
    public void inorder() {
        inorder(root);
    }
    void inorder(Node v) {
        if (v == null) return;
        inorder(v.left);
        System.out.print(v.x+"  ");
        inorder(v.right);
    }

    /** postorder **/
    public void postorder() {
        postorder(root);
    }
    void postorder(Node v) {
        if (v == null) return;
        postorder(v.left);
        postorder(v.right);
        System.out.print(v.x+"  ");
    }

    /** preorder **/
    public void preorder() {
        preorder(root);
    }
    void preorder(Node v) {
        if (v == null) return;
        System.out.print(v.x+"  ");
        postorder(v.left);
        postorder(v.right);
    }

    /** hjelpemtoder **/
    Node findMin(Node v) {
        if (v == null || v.left == null) {
            return v;
        }
        return findMin(v.left);
    }

    Node findMax(Node v) {
        if (v == null || v.right == null) {
            return v;
        }
        return findMax(v.right);
    }

    int height(Node v) {
        if (v == null)
            return 0;
        return Math.max(height(v.left), height(v.right)) + 1;
    }

    // broken metode - printer ut et FINT tre https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
    public void print() {
        List<List<String>> lines = new ArrayList<List<String>>();
        List<Node> level = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node n : level) {
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

            List<Node> tmp = level;
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
        AVLTree t= new AVLTree();

        t.insert(5, 8, 10, 9, 7, 6);
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

        System.out.println("\nPrinter postorder (left-right-root)");
        t.postorder();

        System.out.println("\nPrinter preorder (root-left-right)");
        t.preorder();
        System.out.println("\n----------------------------------------------------------------");

        System.out.println("\nminste: "+t.findMin(t.root).x);
        System.out.println("største: "+t.findMax(t.root).x);
        System.out.println("høyde: "+t.height(t.root));

        System.out.print("\n----------------------------------------------------------------\n");
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
        System.out.println("----------------------------------------------------------------");

        BinarySearchTree bst = new BinarySearchTree();
        AVLTree avl = new AVLTree();
        bst.insert( 1, 6, 9, 2, 3, -1, -3);
        avl.insert( 1, 6, 9, 2, 3, -1, -3);

        System.out.println("\n\n - Sammenligning av BSt og AVL - ");
        System.out.println("BST - Binary search tree");
        bst.print();
        System.out.println("\nAVL - Balansert BST");
        avl.print();
        System.out.println("\n-----------------------------\n");
    }
}
