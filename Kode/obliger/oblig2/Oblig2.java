package obliger.oblig2;

import algoritmer.AdjacencyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Oblig2 {
    static Scanner scanner = new Scanner(System.in, "UTF-8");

    static int countActor = 200; //TODO: fjern
    static int countMovie = 200; //TODO: fjern
    static ArrayList<Movie> movies = new ArrayList<>();
    static AdjacencyList graph = new AdjacencyList();

    /** ideer hvordan fikse: **/
    // 1. Sammenligne og lage kanter samtidig som addNode()
    // 2. Bruke en traverseringsmetode i grafen for å gå gjennom og sammenligne (krever sikkert hvertfall èn loop, starten)
    // > for (actor a : actors): graph.traverseAndCheck(a)
    // 3. Opprette grafen når movies leses inn, ved å gå gjennom grafen for hver movie-linje og opprette kanten med denne infoen
    /** 3. virker riktigst ut kanskje **/

    //region oppgave 1
    static void antKanterOgNoder() {
        System.out.println("------------------------------------");
        int antKanter = 0;
        for (HashSet set : graph.graphList.values()) antKanter += set.size();
        System.out.println("Antall noder: "+graph.graphList.size());
        System.out.println("Antall kanter: "+antKanter);
        System.out.println("------------------------------------");
    }
    static void buildGraph() {
        long start = System.currentTimeMillis();
        //TODO: Denne tar Aaaalt for lang tid - fiks
        for (Actor a : graph.graphList.keySet()) {
            for (Actor b : graph.graphList.keySet()) {
                for (Movie m : movies) {
                    if (a.movies.contains(m.id) && b.movies.contains((m.id)) && !a.name.equals(b.name))
                        graph.addEdge(a, b, m);
                }
            }
        }
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("------------------------------------");
        System.out.println("Time taken: "+(double)elapsedTime/1000+" second(s) ");
    }
    static void readMovies(Scanner movieScanner) {
        int linenr = 0;
        while (movieScanner.hasNextLine() && countMovie-- > 0) {
            String[] line = movieScanner.nextLine().split("\t");
            movies.add(new Movie(line[0], line[1], Double.parseDouble(line[2]), line[3]));
        }
    }
    static void readActors(Scanner actorScanner) {
        int linenr = 0;
        while (actorScanner.hasNextLine() && countActor-- > 0) {
            String[] line = actorScanner.nextLine().split("\t");
            List<String> actorMovies = new ArrayList<>(Arrays.asList(line).subList(2, line.length));
            Actor actor = new Actor(line[0], line[1], actorMovies);
            graph.addNode((actor));
        }
    }
    static void oppgaveEn() throws FileNotFoundException {
        readMovies(new Scanner(new File("movies.tsv")));
        readActors(new Scanner(new File("actors.tsv")));
        scanner.close();
        buildGraph();
        antKanterOgNoder();
    }
    //endregion


    static void finnKortestSti(String nmEn, String nmTo) {
        for (Actor a : graph.graphList.keySet()) {
            if (a.id.equals(nmEn) || a.id.equals(nmTo))
                System.out.println("Bing bong fant: "+a);
        }
    }
    static void oppgaveTo() throws FileNotFoundException {
        // må kjøre oppaveEn for å laste inn grafen
        oppgaveEn();
        finnKortestSti("nm2255973", "nm0000460");
        finnKortestSti("nm0424060", "nm0000243");
        finnKortestSti("nm4689420", "nm0000365");
        finnKortestSti("nm0000288", "nm0001401");
        finnKortestSti("nm0031483", "nm0931324");
    }

    static void oppgaveTre() {
        System.out.println("tre");
    }

    static void oppgaveFire() {
        System.out.println("fire");
    }

    static void velgOppgave(String oppgave) throws FileNotFoundException{
        switch(oppgave.toLowerCase()) {
            case "oppgave 1": oppgaveEn(); break;
            case "oppgave 2": oppgaveTo(); break;
            case "oppgave 3": oppgaveTre(); break;
            case "oppgave 4": oppgaveFire(); break;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        velgOppgave(scanner.nextLine());
    }
}
