package obliger.oblig1;
import java.util.Scanner;

class Teque {

    protected static Node root;

    private static class Node {
        protected int data;
        protected Node neste;

        Node(int data) { this.data = data; }
    }



    // setter nytt element x helt foran i listen (starten) o - x - x
    public static void push_front(int x) {
        Node ny = new Node(x);
        if (root != null) {
            ny.neste = root;
        }
        root = ny;
    }

    // setter nytt element x bakerst i listen (slutten) x - x - o
    public static void push_back(int x) {
        Node ny = new Node(x);
        if (root == null) { root = ny; }
        else {
            Node current = root;
            while (current.neste != null) {
                current = current.neste;
            }
            current.neste = ny;
        }
    }

    // setter nytt element x i midten av listen
    public static void push_middle(int x) {
        Node ny = new Node(x);
        if (root == null) { root = ny; }
        else {
            Node current = root;
            int midten = (size()+1)/2;
            for (int i=0; i < midten-1; i++) {
                current = current.neste;
            }
            ny.neste = current.neste;
            current.neste = ny;
        }
    }

    // printer element på index i
    public static void get(int i) {
        Node current = root;
        for (int a=0; a < i; a++) {
            current = current.neste;
        }
        System.out.println(current.data);
    }

    // returnerer størrelsen til listen - brukes for å finne midten
    public static int size() {
        int size = 0;
        Node current = root;
        while (current != null) {
            size++;
            current = current.neste;
        }
        return size;
    }

    public static boolean isEmpty() {
        return size() <= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();

                String[] lineInfo = line.split(" ");
                String S = lineInfo[0];
                int x = Integer.parseInt(lineInfo[1]);

                switch (S.toLowerCase()) {
                    case "push_back":
                        push_back(x);
                        break;
                    case "push_front":
                        push_front(x);
                        break;
                    case "push_middle":
                        push_middle(x);
                        break;
                    default:
                        get(x);
                }

            }
        scanner.close();
    }
}

