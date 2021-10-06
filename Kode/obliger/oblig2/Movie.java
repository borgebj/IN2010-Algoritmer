package obliger.oblig2;

public class Movie {

    String id, title, votes;
    Double rating;


    public Movie(String id, String title, Double rating, String votes) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.votes = votes;
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

    @Override
    public String toString() {
        return title;
    }
}
