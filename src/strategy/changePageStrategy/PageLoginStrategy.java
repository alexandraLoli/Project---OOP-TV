package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

public class PageLoginStrategy implements ChangePageStrategy{
    @Override
    public OutputData changePage(ActionsInput actionsInput) {
        UserLoggedIn.getInstance().setCurrentPage("login");
        return null;
    }
}
