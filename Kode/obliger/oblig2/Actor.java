package obliger.oblig2;

import java.util.List;

public class Actor {

    String id, name;
    List<String> movies;

    public Actor(String id, String name, List<String> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "("+name+")";
    }
}
