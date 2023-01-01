package database;

import entity.Movie;

import java.util.ArrayList;

public final class MoviesDataBase {

    private static MoviesDataBase instance;
    private final ArrayList<Movie> movies;

    public MoviesDataBase() {
        movies = new ArrayList<>();
    }

    static {
        instance = new MoviesDataBase();
    }

    /* Getters */

    public static MoviesDataBase getInstance() {
        return instance;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Adds movie to database
     * @param movie - the movie we want to add to database
     */
    public void addToMoviesDB(final Movie movie) {
        movies.add(movie);
    }

    /**
     * Resets the database
     */
    public void reset() {
        instance = new MoviesDataBase();
    }

    @Override
    public String toString() {
        return "MoviesDataBase{"
                + "movies=" + movies
                + '}';
    }
}
