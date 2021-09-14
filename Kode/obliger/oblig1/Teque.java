package obliger.oblig1;

import java.util.Scanner;

public class Teque<T> {

    private class Node {
        protected T data;
        protected Node neste;

        Node(T data) { this.data = data; }
    }

    protected Node root;


    // setter nytt element x helt foran i listen (starten) o - x - x
    public void push_front(T x) {
        Node ny = new Node(x);
        if (root != null) {
            ny.neste = root;
        }
        root = ny;
    }

    // setter nytt element x bakerst i listen (slutten) x - x - o
    public void push_back(T x) {
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
    public void push_middle(T x) {
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
    public void get(int i) {
        if (i < 0 || i >= size() || size()==0) { throw new IndexOutOfBoundsException(i+" er utenfor rekkevidden til listen"); }
        else {
            Node current = root;
            for (int a=0; a < i; a++) {
                current = current.neste;
            }
            System.out.println(current.data);
        }
    }

    // returnerer størrelsen til listen - brukes for å finne midten
    public int size() {
        int size = 0;
        Node current = root;
        while (current != null) {
            size++;
            current = current.neste;
        }
        return size;
    }
}

class Main {
    public static void main(String[] args) {

        Teque<Integer> liste = new Teque<>();

        // bruker STDIN for å lese input og gøre operasjoner på teque
        Scanner scanner = new Scanner(System.in);
        boolean fortsett = true;
        while (fortsett) {
            System.out.print("> ");
            String line = scanner.nextLine();
            if (line.equals(" ")) fortsett = false; // stopper

            try {
                String[] lineInfo = line.split(" ");
                String operation = lineInfo[0];
                int number = Integer.parseInt(lineInfo[1]);

                // sjekker operasjonen som skal gjøres
                switch (operation) {
                    case "push_back":
                        liste.push_back(number);
                        break;
                    case "push_front":
                        liste.push_front(number);
                        break;
                    case "push_middle":
                        liste.push_middle(number);
                        break;
                    case "get":
                        liste.get(number);
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) { }
        }
    }
}

