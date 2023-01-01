package fileio.output;

import entity.Movie;
import entity.User;
import entity.UserCredentials;
import site.UserLoggedIn;

import java.util.ArrayList;

public final class OutputData {
    private final String error;
    private final ArrayList<OutputMovie> currentMoviesList;
    private final OutputUser currentUser;

    public OutputData() {
        error = "Error";
        currentMoviesList = new ArrayList<>();
        currentUser = null;
    }

    public OutputData(final String error,
                      final User currentUser,
                      final ArrayList<Movie> currentMoviesList) {
        this.error = error;
        this.currentUser = setUser(currentUser);
        this.currentMoviesList = setMovieList(currentMoviesList);
    }

    public OutputUser getCurrentUser() {
        return currentUser;
    }

    public ArrayList<OutputMovie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public String getError() {
        return error;
    }

    /**
     *
     * @param movieList
     * @return
     */
    public ArrayList<OutputMovie> setMovieList(final ArrayList<Movie> movieList) {
        ArrayList<OutputMovie> list = new ArrayList<>();
        if (movieList != null) {
            for (Movie movie : movieList) {
                list.add(new OutputMovie(
                        movie.getName(),
                        movie.getYear(),
                        movie.getDuration(),
                        movie.getGenres(),
                        movie.getActors(),
                        movie.getCountriesBanned(),
                        movie.getNumLikes(),
                        movie.getRating(),
                        movie.getNumRatings()
                ));
            }
        }
        return list;
    }

    public OutputUser setUser (final User user) {
        return new OutputUser(
                new UserCredentials(
                        UserLoggedIn.getInstance().getCurrentUser()
                                .getCredentials().getName(),
                        UserLoggedIn.getInstance().getCurrentUser()
                                .getCredentials().getPassword(),
                        UserLoggedIn.getInstance().getCurrentUser()
                                .getCredentials().getAccountType(),
                        UserLoggedIn.getInstance().getCurrentUser()
                                .getCredentials().getCountry(),
                        UserLoggedIn.getInstance().getCurrentUser()
                                .getCredentials().getBalance()
                ),
                UserLoggedIn.getInstance().getCurrentUser().getTokensCount(),
                UserLoggedIn.getInstance().getCurrentUser().getNumFreePremiumMovies(),
                UserLoggedIn.getInstance().getCurrentUser().getPurchasedMovies(),
                UserLoggedIn.getInstance().getCurrentUser().getWatchedMovies(),
                UserLoggedIn.getInstance().getCurrentUser().getLikedMovies(),
                UserLoggedIn.getInstance().getCurrentUser().getRatedMovies()

        );
    }

    @Override
    public String toString() {
        return "OutputData{"
                + "error='" + error + '\''
                + ", currentMoviesList=" + currentMoviesList
                + ", currentUser=" + currentUser
                + '}';
    }
}
