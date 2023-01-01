package entity;

import java.util.ArrayList;
import java.util.HashMap;

public final class Movie {
    private final String name;
    private final String year;
    private final Integer duration;
    private final ArrayList<String> genres;
    private final ArrayList<String> actors;
    private final ArrayList<String> countriesBanned;
    private Integer numLikes;
    private Double rating;
    private Integer numRatings;
    private final HashMap<User, Integer> ratings;

    public Movie(final String name,
                 final String year,
                 final Integer duration,
                 final ArrayList<String> genres,
                 final ArrayList<String> actors,
                 final ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
        this.numLikes = 0;
        this.rating = Double.valueOf(0);
        this.numRatings = 0;
        this.ratings = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getYear() {
        return year;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public Integer getNumRatings() {
        return numRatings;
    }

    public Double getRating() {
        return rating;
    }

    public HashMap<User, Integer> getRatings() {
        return ratings;
    }

    public void setRating(final Double rating) {
        this.rating = rating;
    }

    public void setNumLikes(final Integer numLikes) {
        this.numLikes = numLikes;
    }

    public void setNumRatings(final Integer numRatings) {
        this.numRatings = numRatings;
    }

    @Override
    public String toString() {
        return "Movie{"
                + "name='" + name + '\''
                + ", year=" + year
                + ", duration=" + duration
                + ", genres=" + genres
                + ", actors=" + actors
                + ", countriesBanned=" + countriesBanned
                + ", numLikes=" + numLikes
                + ", rating=" + rating
                + ", numRatings=" + numRatings
                + '}';
    }
}
