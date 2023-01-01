package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

public class PageUpgradesStrategy implements ChangePageStrategy{
    @Override
    public OutputData changePage(ActionsInput actionsInput) {
        UserLoggedIn.getInstance().setCurrentPage("upgrades");
        return null;
    }
}
