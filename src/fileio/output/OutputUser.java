package fileio.output;

import entity.Movie;
import entity.Notifications;
import entity.UserCredentials;

import java.util.ArrayList;

public final class OutputUser {

    private final UserCredentials credentials;
    private final Integer tokensCount;
    private final Integer numFreePremiumMovies;
    private final ArrayList<OutputMovie> purchasedMovies;
    private final ArrayList<OutputMovie> watchedMovies;
    private final ArrayList<OutputMovie> likedMovies;
    private final ArrayList<OutputMovie> ratedMovies;
    private final ArrayList<Notifications> notifications;

    public OutputUser(final UserCredentials credentials,
                      final Integer tokensCount,
                      final Integer numFreePremiumMovies,
                      final ArrayList<Movie> purchasedMovies,
                      final ArrayList<Movie> watchedMovies,
                      final ArrayList<Movie> likedMovies,
                      final ArrayList<Movie> ratedMovies,
                      final ArrayList<Notifications> notifications) {
        this.credentials = credentials;
        this.tokensCount = tokensCount;
        this.numFreePremiumMovies = numFreePremiumMovies;
        this.purchasedMovies = setMovieList(purchasedMovies);
        this.watchedMovies = setMovieList(watchedMovies);
        this.likedMovies = setMovieList(likedMovies);
        this.ratedMovies = setMovieList(ratedMovies);
        this.notifications = setNotifications(notifications);
    }

    public Integer getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public Integer getTokensCount() {
        return tokensCount;
    }

    public UserCredentials getCredentials() {
        return credentials;
    }

    public ArrayList<OutputMovie> getLikedMovies() {
        return likedMovies;
    }

    public ArrayList<OutputMovie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public ArrayList<OutputMovie> getRatedMovies() {
        return ratedMovies;
    }

    public ArrayList<OutputMovie> getWatchedMovies() {
        return watchedMovies;
    }

    public ArrayList<Notifications> getNotifications() {
        return notifications;
    }

    /**
     * @param movieList
     * @return
     */
    public ArrayList<OutputMovie> setMovieList(final ArrayList<Movie> movieList) {
        ArrayList<OutputMovie> movie = new ArrayList<>();
        if (movieList != null) {
            for (Movie m : movieList) {
                movie.add(new OutputMovie(
                                m.getName(),
                                m.getYear(),
                                m.getDuration(),
                                m.getGenres(),
                                m.getActors(),
                                m.getCountriesBanned(),
                                m.getNumLikes(),
                                m.getRating(),
                                m.getNumRatings()
                        )
                );
            }
        }
        return  movie;
    }
    private ArrayList<Notifications> setNotifications(
            final ArrayList<Notifications> notifications) {
        ArrayList<Notifications> not = new ArrayList<>();
        if (notifications != null) {
            for (Notifications notif : notifications) {
                not.add(
                        new Notifications(
                                notif.getMovieName(),
                                notif.getMessage()
                        )
                );
            }
        }
        return not;
    }

    @Override
    public String toString() {
        return "OutputUser{"
                + "credentials=" + credentials
                + ", tokensCount=" + tokensCount
                + ", numFreePremiumMovies=" + numFreePremiumMovies
                + ", purchasedMovies=" + purchasedMovies
                + ", watchedMovies=" + watchedMovies
                + ", likedMovies=" + likedMovies
                + ", ratedMovies=" + ratedMovies
                + ", notifications=" + notifications
                + '}';
    }
}
