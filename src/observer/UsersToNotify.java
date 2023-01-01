package observer;

import entity.Movie;

import java.util.ArrayList;

public final class UsersToNotify {
    private String movieName;
    private String message;
    private Movie movie;
    private ArrayList<Observable> users = new ArrayList<>();

    public String getMovieName() {
        return movieName;
    }

    public String getMessage() {
        return message;
    }

    public void setMovie(final Movie movie) {
        this.movie = movie;
    }

    public void setUsers(final ArrayList<Observable> users) {
        this.users = users;
    }

    public ArrayList<Observable> getUsers() {
        return users;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setMovieName(final String movieName) {
        this.movieName = movieName;
    }

    /**
     * Add observer to user list
     * @param user
     */
    public void addObserver(final Observable user) {
        users.add(user);
    }

    /**
     * Send the same notification to all specific users
     * @param movieName
     * @param message
     */
    public void notifyUser(final String movieName,
                           final String message) {
        this.movieName = movieName;
        this.message = message;
        for (Observable user : users) {
            user.notify(movieName, message);
        }
    }

    /**
     * Update the movie lists of all specific users
     * @param movie
     */
    public void update(final Movie movie) {
        this.movie = movie;
        for (Observable user : users) {
            user.update(movie);
        }
    }
}
