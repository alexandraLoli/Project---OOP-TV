package entity;

import observer.Observable;

import java.util.ArrayList;
import java.util.HashMap;

public final class User implements Observable {

    private final UserCredentials credentials;
    private Integer tokensCount;
    private Integer numFreePremiumMovies;
    private final ArrayList<Movie> purchasedMovies;
    private final ArrayList<Movie> watchedMovies;
    private final ArrayList<Movie> likedMovies;
    private final ArrayList<Movie> ratedMovies;
    private final ArrayList<Notifications> notifications;
    private final ArrayList<String> subscribedGenres;

    private final HashMap<String, Integer> genresTop;

    public User(final UserCredentials credentials,
                final Integer tokensCount,
                final Integer numFreePremiumMovies) {
        this.credentials = credentials;
        this.tokensCount = tokensCount;
        this.numFreePremiumMovies = numFreePremiumMovies;
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.subscribedGenres = new ArrayList<>();
        this.genresTop = new HashMap<>();
    }


    public UserCredentials getCredentials() {
        return credentials;
    }

    public Integer getTokensCount() {
        return tokensCount;
    }

    public Integer getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public ArrayList<Notifications> getNotifications() {
        return notifications;
    }

    public ArrayList<String> getSubscribedGenres() {
        return subscribedGenres;
    }

    public HashMap<String, Integer> getGenresTop() {
        return genresTop;
    }

    public void setTokensCount(final Integer tokensCount) {
        this.tokensCount = tokensCount;
    }

    public void setNumFreePremiumMovies(final Integer numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }



    @Override
    public String toString() {
        return "User{"
                + "credentials=" + credentials
                + ", tokensCount=" + tokensCount
                + ", numFreePremiumMovies=" + numFreePremiumMovies
                + ", purchasedMovies=" + purchasedMovies
                + ", watchedMovies=" + watchedMovies
                + ", likedMovies=" + likedMovies
                + ", ratedMovies=" + ratedMovies
                + ", notifications=" + notifications
                + ", subscribedGenres=" + subscribedGenres
                + '}';
    }

    @Override
    public void notify(final String movieName,
                       final String message) {
        this.notifications.add(
                new Notifications(
                        movieName,
                        message
                )
        );
    }

    @Override
    public void update(final Movie movie) {
        if (this.credentials.getAccountType().equals("standard")) {
            this.tokensCount = this.tokensCount + 2;
        } else {
            this.numFreePremiumMovies = this.numFreePremiumMovies + 1;
        }
        this.purchasedMovies.remove(movie);
        this.watchedMovies.remove(movie);
        this.likedMovies.remove(movie);
        this.ratedMovies.remove(movie);
    }
}
