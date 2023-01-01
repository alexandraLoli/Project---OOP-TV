package database;

import factory.databaseFactory.EntityFactory;
import factory.databaseFactory.EntityFactoryProduce;
import fileio.input.InputData;
import fileio.input.MovieInput;
import fileio.input.UserInput;

public class DataBase {

    /**
     * Sets the database
     * @param inputData
     */
    public static void setDataBase(final InputData inputData) {
        EntityFactory userFactory = EntityFactoryProduce.getFactory("user");
        for (UserInput user : inputData.getUsers()) {
            UsersDataBase.getInstance().addToUsersDB(userFactory.createUser(user));
        }

        EntityFactory movieFactory = EntityFactoryProduce.getFactory("movie");
        for (MovieInput movie : inputData.getMovies()) {
            MoviesDataBase.getInstance().addToMoviesDB(movieFactory.createMovie(movie));
        }
    }

    /**
     * Reset the database for every test
     */
    public static void resetDB() {
        UsersDataBase.getInstance().reset();
        MoviesDataBase.getInstance().reset();
    }
}
