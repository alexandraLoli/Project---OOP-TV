package observer;

import entity.Movie;

public interface Observable {
    /**
     * Used to notificate users
     * @param movieName
     * @param message
     */
    void notify(String movieName, String message);

    /**
     * Used to update movie lists
     * @param movie
     */
    void update(Movie movie);
}
