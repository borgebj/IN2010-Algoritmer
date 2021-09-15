package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class binarySearch {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=150; i++) {
            list.add(i);
        }
        int tall = 123;
        int tall2 = 155;

        // simple search
        System.out.println("Simple search:");
        System.out.println("Fant tall:"+tall+" "+simpleSearch(list, tall));
        System.out.println("Fant tall:"+tall2+" "+simpleSearch(list, tall2));

        // Binary search
        System.out.println("\nBinary Search:");
        System.out.println("Fant tall: "+binarySearch(list, tall));
    }

    private static boolean simpleSearch(List<Integer> A, Integer x) {
        for (int i=0; i<A.size(); i++) {
            if(A.get(i).equals(x))
                return true;
        }
        return false;
    }

    private static boolean binarySearch(List<Integer> A, Integer x) {
        int low = 0;
        int high = A.size()-1;

        while (low <= high) {
            int mid = (low+high)/2;

            if (A.get(mid).equals(x))
                return true;

            else if (A.get(mid) < x)
                low = mid + 1;

            else if (A.get(mid) > x)
                high = mid - 1;
        }
        return false;
    }
}
