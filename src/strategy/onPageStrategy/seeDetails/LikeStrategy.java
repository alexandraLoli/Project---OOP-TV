package strategy.onPageStrategy.seeDetails;

import entity.Movie;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public class LikeStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(ActionsInput actionsInput) {
        for (Movie movie : UserLoggedIn.getInstance().getCurrentUser().getWatchedMovies()) {
            if (movie.getName().equals(UserLoggedIn.getInstance().getCurrentMovie().getName())) {
                movie.setNumLikes(movie.getNumLikes() + 1);
                UserLoggedIn.getInstance().getCurrentUser().getLikedMovies().add(movie);
                return new OutputData(
                        null,
                        UserLoggedIn.getInstance().getCurrentUser(),
                        UserLoggedIn.getInstance().getCurrentMovieList()
                );
            }
        }
        return new OutputData();
    }
}
