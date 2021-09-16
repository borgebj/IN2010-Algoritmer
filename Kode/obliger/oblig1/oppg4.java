package obliger.oblig1;

import algoritmer.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;

public class oppg4 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7 ));

        BinarySearchTree bst = new BinarySearchTree();
        //for (int x : array) bst.insert(x);
        bst.insert(5, 8, 10, 9, 7, 6, 2, 4, 3, 1, 0);
        bst.print();
    }
}
