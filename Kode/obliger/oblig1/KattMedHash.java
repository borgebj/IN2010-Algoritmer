package obliger.oblig1;

import java.util.HashMap;
import java.util.Scanner;

public class KattMedHash {

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

    //lager tre
    public static void opprettTre(HashMap<String, String> tre, Scanner scanner) {
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> tre = new HashMap<>();
        String katt = scanner.next(); scanner.nextLine();

        opprettTre(tre, scanner);
        String path = finnKatt(tre, katt);

        System.out.println(path);

    }
}
