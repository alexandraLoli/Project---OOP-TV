package strategy.onPageStrategy.seeDetails;

import entity.Movie;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public class RateStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(ActionsInput actionsInput) {
        if (actionsInput.getRate() <= 5) {
            for (Movie movie : UserLoggedIn.getInstance().getCurrentUser().getWatchedMovies()) {
                if (movie.getName().equals(UserLoggedIn.getInstance().getCurrentMovie().getName())) {
                    movie.setNumRatings(movie.getNumRatings() + 1);
                    movie.getRatings().add(actionsInput.getRate());
                    Double m = Double.valueOf(0);
                    for (Integer i : movie.getRatings()) {
                        m += i;
                    }
                    movie.setRating(m / movie.getNumRatings());
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
}
