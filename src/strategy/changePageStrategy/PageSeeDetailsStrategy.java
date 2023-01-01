package strategy.changePageStrategy;

import entity.Movie;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

import java.util.ArrayList;

public final class PageSeeDetailsStrategy implements ChangePageStrategy {
    @Override
    public OutputData changePage(final ActionsInput actionsInput) {
        for (Movie movie : UserLoggedIn.getInstance().getCurrentMovieList()) {
            if (movie.getName().equals(actionsInput.getMovie())) {
                UserLoggedIn.getInstance().setCurrentMovie(movie);
                ArrayList<Movie> movies = new ArrayList<>();
                for (Movie m : UserLoggedIn.getInstance().getCurrentMovieList()) {
                    if (!m.getName().equals(actionsInput.getMovie())) {
                        movies.add(m);
                    }
                }
                UserLoggedIn.getInstance().getCurrentMovieList().removeAll(movies);
                UserLoggedIn.getInstance().setCurrentPage("see details");
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
