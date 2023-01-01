package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

public final class PageMoviesStrategy implements ChangePageStrategy {
    @Override
    public OutputData changePage(final ActionsInput actionsInput) {
        UserLoggedIn.getInstance().updateCurrentMovieList();
        UserLoggedIn.getInstance().setCurrentPage("movies");
        return new OutputData(
                null,
                UserLoggedIn.getInstance().getCurrentUser(),
                UserLoggedIn.getInstance().getCurrentMovieList()
        );
    }
}
