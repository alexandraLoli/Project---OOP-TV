package fileio.input;

import java.util.ArrayList;

public final class MovieInput {
    private String name;
    private String year;
    private Integer duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    public MovieInput() {

    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public Integer getDuration() {
        return duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public void setDuration(final Integer duration) {
        this.duration = duration;
    }

    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    @Override
    public String toString() {
        return "MovieInput{"
                + "name='" + name + '\''
                + ", year=" + year
                + ", duration=" + duration
                + ", genres=" + genres
                + ", actors=" + actors
                + ", countriesBanned=" + countriesBanned
                + '}';
    }
}
