package observer;

import entity.Movie;
import fileio.input.ActionsInput;

import java.util.ArrayList;
import java.util.Map;

public class UsersToNotify {
    String movieName;
    String message;
    Movie movie;
    private ArrayList<Observable> users = new ArrayList<>();

    public void addObserver(Observable user) {
        users.add(user);
    }

    public void notifyUser(String movieName, String message) {
        this.movieName = movieName;
        this.message = message;
        for (Observable user : users) {
            user.notify(movieName, message);
        }
    }

    public void update(Movie movie) {
        this.movie = movie;
        for (Observable user : users) {
            user.update(movie);
        }
    }
}
