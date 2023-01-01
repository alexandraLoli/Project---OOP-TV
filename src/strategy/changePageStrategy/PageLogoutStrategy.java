package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

public final class PageLogoutStrategy implements ChangePageStrategy {
    @Override
    public OutputData changePage(final ActionsInput actionsInput) {
        UserLoggedIn.getInstance().reset();
        return null;
    }
}
