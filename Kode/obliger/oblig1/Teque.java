package obliger.oblig1;

public class Teque<T> {

    private class Node {
        protected T data;
        protected Node neste;

        Node(T data) { this.data = data; }
    }

    protected Node root;


    // setter node med ny data inn som roten, flytter roten oppover
    public void push_front(T x) {
        Node ny = new Node(x);
        if (root == null) { root = ny; }
        else {
            ny.neste = root;
            root = ny;
        }
    }

    public void print() {
        Node current = root;
        while (current.neste != null) {
            System.out.println(current.data);
            current = current.neste;
        }
    }
}

class Main {
    public static void main(String[] args) {

        Teque liste = new Teque();
        liste.push_front(2);
        liste.push_front(16);
        liste.push_front(12);

        liste.print();
    }
}

