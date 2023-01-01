package observer;

import entity.Movie;
import fileio.input.ActionsInput;

public interface Observable {
    void notify(String movieName, String message);
    void update(Movie movie);
}
