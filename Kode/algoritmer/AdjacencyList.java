package algoritmer;

import obliger.oblig2.Actor;
import obliger.oblig2.Movie;

import java.util.*;


public class AdjacencyList {
    public static class Edge {

        Movie label;
        double weight;
        Actor to, from;

        public Edge(Actor to, Actor from, Movie label) {
            this.label = label;
            this.weight = label.getRating();
            this.to = to;
            this.from = from;
        }

        @Override
        public String toString() {
            return " {"+from+" - "+to+" ("+weight+")}";
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
    }

    //TODO: Unødvendig?
    public boolean containsEdge(Edge e) {
        for (HashSet<Edge> set : graphList.values()) {
            if (set.contains(e)) return true;
        } return false;
    }
    public void addNode(Actor a) {
        if (!graphList.containsKey(a)) {
            graphList.put(a, new HashSet<>());
        }
    }

    public List<Actor> getNeighbours(Actor a) {
        List<Actor> neighbours = new ArrayList<>();
        HashSet<Edge> kanter = graphList.get(a);
        for (Edge e : kanter) {
            if (!neighbours.contains(e.from) && !e.from.equals(a)) neighbours.add(e.from);
            if (!neighbours.contains(e.to) && !e.to.equals(a)) neighbours.add(e.to);
        }
        return neighbours;
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
