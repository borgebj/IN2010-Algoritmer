package kattis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


// med linked list - ikke 100% riktig
public class TequeKattis {
    private static class Treque {
        public LinkedList<Integer> front = new LinkedList<>();
        public LinkedList<Integer> back = new LinkedList<>();

        public void push_back(int element) {
            back.addLast(element);
            if (back.size() > front.size()) front.addLast(back.removeFirst());
        }
        public void push_front(int element) {
            front.addFirst(element);
            if (back.size() < front.size()) back.addFirst(front.removeLast());
        }
        public void push_middle(int element) {
            if (front.size() > back.size()) back.addFirst(element);
            else front.addLast(element);
        }
        public void get(int i) {
            if (i < front.size()) System.out.println(front.get(i));
            else System.out.println(back.get(i-front.size()));
        }
        public int size() {
            return front.size()+back.size();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Treque treque = new Treque();

        int iterations = scanner.nextInt();

        for (int i=0; i < iterations; i++) {
            String operation = scanner.next();
            int element = scanner.nextInt();

            switch (operation) {
                case "push_back":
                    treque.push_back(element);
                    break;
                case "push_front":
                    treque.push_front(element);
                    break;
                case "push_middle":
                    treque.push_middle(element);
                    break;
                default:
                    treque.get(element);
                    break;
            }
        }
        scanner.close();
    }
}

// teque med arraylist - ikke 100% riktig
class TequeKattis1 {

    static ArrayList<String> list = new ArrayList<>();

    public static void push_front(String element) { list.add(0, element); }
    public static void push_back(String element) {
        list.add(element);
    }
    public static void push_middle(String element) {
        list.add((list.size()+1)/2, element);
    }
    public static void get(String element) {
        System.out.println(list.get(Integer.parseInt(element)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = scanner.nextInt(); scanner.nextLine();

        for (int i=0; i < iterations; i++) {
            String[] line = scanner.nextLine().trim().split(" ");

            switch (line[0]) {
                case "push_back":
                    push_back(line[1]);
                    break;
                case "push_front":
                    push_front(line[1]);
                    break;
                case "push_middle":
                    push_middle(line[1]);
                    break;
                default:
                    get(line[1]);
                    break;
            }
        }
        scanner.close();
    }
}