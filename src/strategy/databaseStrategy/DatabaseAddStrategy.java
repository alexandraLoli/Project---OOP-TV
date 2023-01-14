package strategy.databaseStrategy;

import database.MoviesDataBase;
import database.UsersDataBase;
import entity.User;
import factory.databaseFactory.EntityFactory;
import factory.databaseFactory.EntityFactoryProduce;
import fileio.input.ActionsInput;
import fileio.input.MovieInput;
import fileio.output.OutputData;
import observer.UsersToNotify;

public final class DatabaseAddStrategy implements DatabaseStrategy {
    @Override
    public OutputData action(final ActionsInput actionsInput) {
        MovieInput movieToAdd = actionsInput.getAddedMovie();
        for (int i = 0; i < MoviesDataBase.getInstance().getMovies().size(); i++) {
            if (movieToAdd.getName().equals(
                    MoviesDataBase.getInstance().getMovies().get(i).getName()
            )) {
                return new OutputData();
            }
        }
        addMovie(movieToAdd);
        return null;
    }

    private void addMovie(final MovieInput movieToAdd) {
        EntityFactory movieFactory = EntityFactoryProduce.getFactory("movie");
        MoviesDataBase.getInstance().addToMoviesDB(movieFactory.createMovie(movieToAdd));

        UsersToNotify usersToNotify = new UsersToNotify();
        for (User user : UsersDataBase.getInstance().getUsers()) {
            boolean userCanBeAdded = false;
            for (String movieToAddGenre : movieToAdd.getGenres()) {
                for (String genre : user.getSubscribedGenres()) {
                    if (genre.equals(movieToAddGenre)) {
                        boolean ok = true;
                        for (String countriesBanned : movieToAdd.getCountriesBanned()) {
                            if (countriesBanned.equals(user.getCredentials().getCountry())) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            userCanBeAdded = true;
                        }
                    }
                    if (userCanBeAdded) {
                        break;
                    }
                }
                if (userCanBeAdded) {
                    break;
                }
            }
            if (userCanBeAdded) {
                usersToNotify.addObserver(user);
            }
        }
        usersToNotify.notifyUser(movieToAdd.getName(), "ADD");
    }
}
