package fileio.input;

import java.util.ArrayList;

public final class InputData {

    private ArrayList<UserInput> users;
    private ArrayList<MovieInput> movies;
    private ArrayList<ActionsInput> actions;

    public InputData() {

    }

    public ArrayList<UserInput> getUsers() {
        return users;
    }

    public ArrayList<MovieInput> getMovies() {
        return movies;
    }

    public ArrayList<ActionsInput> getActions() {
        return actions;
    }

    public void setUsers(final ArrayList<UserInput> users) {
        this.users = users;
    }

    public void setMovies(final ArrayList<MovieInput> movies) {
        this.movies = movies;
    }

    public void setActions(final ArrayList<ActionsInput> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "InputData{"
                + "users=" + users
                + ", movies=" + movies
                + ", actions=" + actions
                + '}';
    }
}
