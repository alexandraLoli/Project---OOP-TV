package strategy.onPageStrategy.seeDetails;

import entity.Movie;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public final class PurchaseStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(final ActionsInput actionsInput) {
        for (Movie movie : UserLoggedIn.getInstance().getCurrentUser().getPurchasedMovies()) {
            if (movie.getName().equals(UserLoggedIn.getInstance().getCurrentMovie().getName())) {
                return new OutputData();
            }
        }
        for (Movie movie : UserLoggedIn.getInstance().getCurrentMovieList()) {
            if (movie.getName().equals(UserLoggedIn.getInstance().getCurrentMovie().getName())) {
                if (UserLoggedIn.getInstance()
                        .getCurrentUser().getCredentials().getAccountType().equals("standard")) {
                    if (!standardAccount(movie)) {
                        return new OutputData();
                    } else {
                        return new OutputData(
                                null,
                                UserLoggedIn.getInstance().getCurrentUser(),
                                UserLoggedIn.getInstance().getCurrentMovieList()
                        );
                    }
                } else {
                    if (!premiumAccount(movie)) {
                        return new OutputData();
                    } else {
                        return new OutputData(
                                null,
                                UserLoggedIn.getInstance().getCurrentUser(),
                                UserLoggedIn.getInstance().getCurrentMovieList()
                        );
                    }
                }
            }
        }
        return new OutputData();
    }

    /**
     * Method used when a premium user buys a movie
     * @param movie
     * @return
     */
    private boolean premiumAccount(final Movie movie) {
        if (UserLoggedIn.getInstance().getCurrentUser().getNumFreePremiumMovies()
                >= 1) {
            int premium = UserLoggedIn.getInstance().getCurrentUser()
                    .getNumFreePremiumMovies()
                    - 1;
            UserLoggedIn.getInstance().getCurrentUser().getPurchasedMovies().add(movie);
            UserLoggedIn.getInstance().getCurrentUser().setNumFreePremiumMovies(premium
            );
            return true;
        } else {
            if (UserLoggedIn.getInstance().getCurrentUser().getTokensCount() >= 2) {
                int myTokens = UserLoggedIn.getInstance().getCurrentUser()
                        .getTokensCount() - 2;
                UserLoggedIn.getInstance().getCurrentUser().getPurchasedMovies()
                        .add(movie);
                UserLoggedIn.getInstance().getCurrentUser().setTokensCount(myTokens);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Method used when a standard user buys a movie
     * @param movie
     * @return
     */
    public boolean standardAccount(final Movie movie) {
        if (UserLoggedIn.getInstance().getCurrentUser().getTokensCount() >= 2) {
            int myTokens = UserLoggedIn.getInstance().getCurrentUser().getTokensCount()
                    - 2;
            UserLoggedIn.getInstance().getCurrentUser().getPurchasedMovies().add(movie);
            UserLoggedIn.getInstance().getCurrentUser().setTokensCount(myTokens);
            return true;
        } else {
            return false;
        }
    }
}
