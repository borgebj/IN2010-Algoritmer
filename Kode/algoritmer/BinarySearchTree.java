package algoritmer;

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

    void insert(int x) {
        root = insert(root, x);
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


    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();

        t.insert(5);
        t.insert(3);
        t.insert(12);
        t.insert(2);
        t.insert(6);
        t.insert(9);
        t.insert(7);

        System.out.println("6: "+t.contains(6));
        System.out.println("7: "+t.contains(7));
        System.out.println("5: "+t.contains(5));
        System.out.println("9: "+t.contains(9));

        System.out.println("\nFjerner 6 og 7");
        t.remove(6);
        t.remove(7);

        System.out.println("6: "+t.contains(6));
        System.out.println("7: "+t.contains(7));
        System.out.println("5: "+t.contains(5));

        System.out.println("\nPrinter inorder");
        t.inorder();

        System.out.println("\nPrinter postorder");
        t.postorder();
    }
}
