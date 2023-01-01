package fileio.output;

import java.util.ArrayList;

public final class OutputMovie {
    private final String name;
    private final String year;
    private final Integer duration;
    private final ArrayList<String> genres;
    private final ArrayList<String> actors;
    private final ArrayList<String> countriesBanned;
    private final Integer numLikes;
    private final Double rating;
    private final Integer numRatings;


    public OutputMovie(final String name,
                       final String year,
                       final Integer duration,
                       final ArrayList<String> genres,
                       final ArrayList<String> actors,
                       final ArrayList<String> countriesBanned,
                       final Integer numLikes,
                       final Double rating,
                       final Integer numRatings) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
        this.numLikes = numLikes;
        this.rating = rating;
        this.numRatings = numRatings;
    }

    public Integer getNumRatings() {
        return numRatings;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public String getYear() {
        return year;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "OutputMovie{"
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
