package strategy.changePageStrategy;

import fileio.input.ActionsInput;
import fileio.input.UserInput;
import fileio.output.OutputData;
import site.UserLoggedIn;

public class PageRegisterStrategy implements ChangePageStrategy{
    @Override
    public OutputData changePage(ActionsInput actionsInput) {
        UserLoggedIn.getInstance().setCurrentPage("register");
        return null;
    }
}
