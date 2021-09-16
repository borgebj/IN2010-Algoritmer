package kattis;

import java.util.ArrayList;
import java.util.Scanner;

public class TequeKattis {

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

