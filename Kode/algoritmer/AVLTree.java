package algoritmer;

public class AVLTree {
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


    /*
            Z                Y
         T0  Y           Z      X
           T1  X       T0 T1  T2 T3
             T2 T3

     */
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

    /** balance-insert **/
    void insert(int x) {
        root = insert(root, x);
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
    void remove(int x) {
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


    /** contains**/
    boolean contains(int x) {
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
    void inorder() {
        inorder(root);
    }
    void inorder(Node v) {
        if (v == null) return;
        inorder(v.left);
        System.out.print(v.x+" ");
        inorder(v.right);
    }

    /** postorder **/
    void postorder() {
        postorder(root);
    }
    void postorder(Node v) {
        if (v == null) return;
        postorder(v.left);
        postorder(v.right);
        System.out.print(v.x+" ");
    }

    /** preorder **/
    void preorder() {
        preorder(root);
    }
    void preorder(Node v) {
        if (v == null) return;
        System.out.print(v.x+" ");
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


    public static void main(String[] args) {
        AVLTree t= new AVLTree();
        System.out.println(">> 5, 4, 8, 3, 5, 7, 9");
        t.insert(5);
        t.insert(4);
        t.insert(8);
        t.insert(3);
        t.insert(5);
        t.insert(7);
        t.insert(9);

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
        System.out.println("\n---------------------------------");

        System.out.println("\nminste: "+t.findMin(t.root).x);
        System.out.println("største: "+t.findMax(t.root).x);
        System.out.println("høyde: "+t.height(t.root));

        System.out.print("\n---------------------------------");
        print2D(t.root);
        System.out.println("---------------------------------");
        System.out.print("add: 12 og 6");
        t.insert(12);
        t.insert(6);
        print2D(t.root);
        System.out.println("---------------------------------");
        System.out.print("remove: 5");
        t.remove(5);
        print2D(t.root);
        System.out.println("---------------------------------");
    }

    // tatt fra internett - lager en 2d illustrasjon av treet   (https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/)
    static final int COUNT = 10;
    static void print2D(Node root) {
        print2DUtil(root, 0);
    }
    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.x + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }
}
