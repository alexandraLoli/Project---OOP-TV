package site;

import database.MoviesDataBase;
import entity.Movie;
import entity.User;

import java.util.ArrayList;

public final class UserLoggedIn {

    private static UserLoggedIn instance;
    private User currentUser;
    private ArrayList<Movie> currentMovieList;

    private String currentPage;
    private Movie currentMovie;

    public UserLoggedIn() {
        currentPage = "homepage neauthenticated";
        currentMovieList = new ArrayList<>();
    }

    static {
        instance = new UserLoggedIn();
    }

    public static UserLoggedIn getInstance() {
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public ArrayList<Movie> getCurrentMovieList() {
        return currentMovieList;
    }

    public void setCurrentMovieList(final ArrayList<Movie> currentMovieList) {
        this.currentMovieList = currentMovieList;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(final String currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * Updates the movie list with all movies except the banned ones
     */
    public void updateCurrentMovieList() {
        currentMovieList = new ArrayList<>();
        for (Movie movie : MoviesDataBase.getInstance().getMovies()) {
            boolean banned = false;
            for (String country : movie.getCountriesBanned()) {
                if (country.equals(currentUser.getCredentials().getCountry())) {
                    banned = true;
                    break;
                }
            }

            if (!banned) {
                currentMovieList.add(movie);
            }
        }
    }

    /**
     * Changes the current user
     */
    public void reset() {
        instance = new UserLoggedIn();
    }
}
