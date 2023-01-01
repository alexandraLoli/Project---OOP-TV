package entity;

import java.util.ArrayList;

public final class Movie{
    private final String name;
    private final Integer year;
    private final Integer duration;
    private final ArrayList<String> genres;
    private final ArrayList<String> actors;
    private final ArrayList<String> countriesBanned;
    private Integer numLikes;
    private Double rating;
    private Integer numRatings;
    private final ArrayList<Integer> ratings;

    public Movie(final String name,
                 final Integer year,
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
        this.ratings = new ArrayList<>();
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

    public Integer getYear() {
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

    public ArrayList<Integer> getRatings() {
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
