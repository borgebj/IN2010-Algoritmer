package algoritmer;

import obliger.oblig2.Actor;
import obliger.oblig2.Movie;

import java.util.HashMap;
import java.util.HashSet;


public class AdjacencyList {
    public class Edge {
        Movie weight;
        Actor to, from;
        public Edge(Actor to, Actor from, Movie weight) {
            this.weight = weight;
            this.to = to;
            this.from = from;
        }

        @Override
        public String toString() {
            return " ["+from+" -> "+to+" ("+weight+") ] ";
        }
    }

    public HashMap<Actor, HashSet<Edge>> graphList;

    public AdjacencyList(){
        graphList = new HashMap<>();
    }

    // legger til edge
    public void addEdge(Actor a, Actor b, Movie weight) {
        if (!graphList.containsKey(a)) graphList.put(a, new HashSet<>());
        if (!graphList.containsKey(b)) graphList.put(b, new HashSet<>());
        graphList.get(a).add(new Edge(a, b, weight));
        graphList.get(b).add(new Edge(b, a, weight));
    }

    public void addNode(Actor a) {
        if (!graphList.containsKey(a)) {
            graphList.put(a, new HashSet<>());
        }
    }

    public void print(){
        for (Actor key : graphList.keySet()) {
            System.out.println(key+" - "+graphList.get(key));
        }
    }

//    // test
//    public static void main(String[] args) {
////        AdjacencyList graf = new AdjacencyList();
////        graf.addEdge("1", "0", 1);
////        graf.addEdge("1", "2", 1);
////        graf.addEdge("2", "0", 2);
////        graf.addEdge("1", "3", 2);
////        graf.addEdge("0", "3", 3);
////        graf.print();
//    }
}
