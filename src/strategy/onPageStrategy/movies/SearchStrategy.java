package strategy.onPageStrategy.movies;

import database.MoviesDataBase;
import entity.Movie;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public class SearchStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(ActionsInput actionsInput) {
        String startsWith = actionsInput.getStartsWith();

        for (Movie movie : MoviesDataBase.getInstance().getMovies()) {
            if (!movie.getName().startsWith(startsWith)) {
                UserLoggedIn.getInstance().getCurrentMovieList().remove(movie);
            }
        }
        return new OutputData(
                null,
                UserLoggedIn.getInstance().getCurrentUser(),
                UserLoggedIn.getInstance().getCurrentMovieList()
        );
    }
}
