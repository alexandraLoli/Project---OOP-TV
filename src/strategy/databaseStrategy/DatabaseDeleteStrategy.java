package strategy.databaseStrategy;

import database.MoviesDataBase;
import database.UsersDataBase;
import entity.Movie;
import entity.User;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import observer.UsersToNotify;

public final class DatabaseDeleteStrategy implements DatabaseStrategy {
    @Override
    public OutputData action(final ActionsInput actionsInput) {
        String movieToDelete = actionsInput.getDeletedMovie();
        Movie movie = null;
        for (int i = 0; i < MoviesDataBase.getInstance().getMovies().size(); i++) {
            if (movieToDelete.equals(
                    MoviesDataBase.getInstance().getMovies().get(i).getName()
            )) {
                movie = MoviesDataBase.getInstance().getMovies().get(i);
            }
        }
        if (movie == null) {
            return new OutputData();
        } else {
            deleteMovie(movie);
            return null;
        }
    }

    private void deleteMovie(final Movie movie) {
        UsersToNotify usersToNotify = new UsersToNotify();
        for (User user : UsersDataBase.getInstance().getUsers()) {
            for (Movie moviePurchased : user.getPurchasedMovies()) {
                if (moviePurchased.getName().equals(movie.getName())) {
                    usersToNotify.addObserver(user);
                    break;
                }
            }
        }
        usersToNotify.notifyUser(movie.getName(), "DELETE");
        usersToNotify.update(movie);
    }
}
