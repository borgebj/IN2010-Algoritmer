package obliger.oblig2;

import algoritmer.AdjacencyList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Oblig2 {
    static Scanner scanner = new Scanner(System.in, "UTF-8");

    static int countActor = 1000; //TODO: fjern
    static int countMovie = 1000; //TODO: fjern
    static ArrayList<Movie> movies = new ArrayList<>();
    static AdjacencyList graph = new AdjacencyList();

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
        for (Movie m : movies) {
            for (Actor a : m.playingIn) {
                for (Actor b : m.playingIn) {
                    if (a != b) graph.addEdge(a, b, m);
                }
            }
        }
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("------------------------------------");
        System.out.println("Tid (edges): "+(double)elapsedTime/1000+" s");
    }
    static void readMovies(Scanner movieScanner) {
        long start = System.currentTimeMillis();
        //TODO: Nye problemet: O(|m|*|n|)?
        while (movieScanner.hasNextLine() /*&& countMovie-- > 0*/) {
            String[] line = movieScanner.nextLine().split("\t");
            Movie movie = new Movie(line[0], line[1], Double.parseDouble(line[2]), line[3]);
            movies.add(movie);
            for (Actor actor : graph.graphList.keySet())
                if (actor.hasMovie(line[0])) movie.addActor(actor);
        }
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Tid (movies): "+(double)elapsedTime/1000+" s");

    }
    static void readActors(Scanner actorScanner) {
        long start = System.currentTimeMillis();
        while (actorScanner.hasNextLine() /*&& countActor-- > 0*/) {
            String[] line = actorScanner.nextLine().split("\t");
            List<String> actorMovies = new ArrayList<>(Arrays.asList(line).subList(2, line.length));
            graph.addNode(new Actor(line[0], line[1], actorMovies));
        }
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Tid (actors): "+(double)elapsedTime/1000+" s");
    }
    static void oppgaveEn() throws FileNotFoundException {
        System.out.println("------------------------------------");
        readActors(new Scanner(new File("actors.tsv")));
        readMovies(new Scanner(new File("movies.tsv")));
        scanner.close();
        buildGraph();
        antKanterOgNoder();
    }
    //endregion

    static void finnKortestSti(String nmEn, String nmTo) {
        Actor en = null;
        Actor to = null;
        for (Actor a : graph.graphList.keySet()) {
            if (a.id.equals(nmEn)) en = a;
            if (a.id.equals(nmTo)) to = a;
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
