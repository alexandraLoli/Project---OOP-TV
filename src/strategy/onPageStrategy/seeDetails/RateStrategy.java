package strategy.onPageStrategy.seeDetails;

import entity.Movie;
import entity.User;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

import java.util.Map;

public final class RateStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(final ActionsInput actionsInput) {

        for (Movie movie : UserLoggedIn.getInstance().getCurrentUser().getRatedMovies()) {
            if (movie.getName().equals(UserLoggedIn.getInstance().getCurrentMovie().getName())) {
                movie.getRatings().put(UserLoggedIn.getInstance()
                        .getCurrentUser(), actionsInput.getRate());
                movie.getRatings().put(UserLoggedIn.getInstance()
                        .getCurrentUser(), actionsInput.getRate());
                calculateRating(movie);
                return new OutputData(
                        null,
                        UserLoggedIn.getInstance().getCurrentUser(),
                        UserLoggedIn.getInstance().getCurrentMovieList()
                );
            }
        }
        if (actionsInput.getRate() <= 5) {
            for (Movie movie : UserLoggedIn.getInstance().getCurrentUser().getWatchedMovies()) {
                if (movie.getName().equals(UserLoggedIn.getInstance()
                        .getCurrentMovie().getName())) {
                    movie.setNumRatings(movie.getNumRatings() + 1);
                    movie.getRatings().put(UserLoggedIn.getInstance()
                            .getCurrentUser(), actionsInput.getRate());
                    calculateRating(movie);
                    UserLoggedIn.getInstance().getCurrentUser().getRatedMovies().add(movie);
                    return new OutputData(
                            null,
                            UserLoggedIn.getInstance().getCurrentUser(),
                            UserLoggedIn.getInstance().getCurrentMovieList()
                    );
                }
            }
        }
        return new OutputData();
    }

    /**
     * Calculate the rating of a movie
     * @param movie
     */
    private void calculateRating(final Movie movie) {
        Double m = Double.valueOf(0);
        for (Map.Entry<User, Integer> i : movie.getRatings().entrySet()) {
            m += i.getValue();
        }
        movie.setRating(m / movie.getNumRatings());
    }
}
