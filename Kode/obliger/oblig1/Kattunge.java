package obliger.oblig1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Kattunge {

    // går gjennom treet, leter etter og oppdaterer katten, samtidig som skriver den ut
    public static String finnKatt(HashMap<String, String> tre, String katt) {
        StringBuilder path = new StringBuilder();

        while(tre.containsKey(katt)) {
            path.append(katt).append(" > ");

            katt = tre.get(katt);
        }

        path.deleteCharAt(path.length()-2);
        return path.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File fil = new File(args[0]);
        Scanner scanner = new Scanner(fil);

        // første er kattenode + hashmap for å representere treet
        String katt = scanner.next(); scanner.nextLine();
        HashMap<String, String> tre = new HashMap<>();

        // Lager treet
        while(true) {
            String parent = scanner.next();

            if(parent.contains("-1"))
                break;
            else {
                String[] barneNoder = scanner.nextLine().split(" ");
                for (String s : barneNoder)
                    tre.put(s, parent);
            }
        }
        String path = finnKatt(tre, katt);
        System.out.println(path);
        scanner.close();
    }
}