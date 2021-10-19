package obliger.oblig2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Movie {

    String id, title, votes;
    Double rating;
    List<Actor> playingIn = new ArrayList<>();

    public Movie(String id, String title, Double rating, String votes) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.votes = votes;
    }

    public void addActor(Actor a) {
        playingIn.add(a);
    }

    public boolean hasActor(Actor a) {
        return playingIn.contains(a);
    }

    // getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVotes() {
        return votes;
    }

    public Double getRating() {
        return rating;
    }

    public List<Actor> getActors() { return playingIn; }

    @Override
    public String toString() {
        return title+"\n"+playingIn;
    }
}
