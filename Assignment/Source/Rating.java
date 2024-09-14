// import java.util.*;

public class Rating {
    private int id_user;
    private int id_movie;
    private int rating_score;
    private long timestamp_of_the_rating;

    public Rating(int id_user, int id_movie, int rating_score, long timestamp_of_the_rating) {
        this.id_user = id_user;
        this.id_movie = id_movie;
        this.rating_score = rating_score;
        this.timestamp_of_the_rating = timestamp_of_the_rating;
    }

    public int get_id_user() {
        return id_user;
    }

    public void set_id_user(int id_user) {
        this.id_user = id_user;
    }

    public int get_id_movie() {
        return id_movie;
    }

    public void set_id_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public int get_rating_score() {
        return rating_score;
    }

    public void set_rating_score(int rating_score) {
        this.rating_score = rating_score;
    }

    public long get_timestamp_of_the_rating() {
        return timestamp_of_the_rating;
    }

    public void set_timestamp_of_the_rating(long timestamp_of_the_rating) {
        this.timestamp_of_the_rating = timestamp_of_the_rating;
    }

    @Override
    public String toString() {
        return String.format("Rating[%d, %d, %d, %ld]", id_user, id_movie, rating_score, timestamp_of_the_rating);
    }
}
