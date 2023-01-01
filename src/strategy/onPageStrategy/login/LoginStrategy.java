package strategy.onPageStrategy.login;

import database.UsersDataBase;
import entity.User;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public final class LoginStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(final ActionsInput actionsInput) {
        String name = actionsInput.getCredentials().getName();
        String password = actionsInput.getCredentials().getPassword();

        for (User user : UsersDataBase.getInstance().getUsers()) {
            if (user.getCredentials().getName().equals(name)
                    && user.getCredentials().getPassword().equals(password)) {
                UserLoggedIn.getInstance().setCurrentUser(user);
                UserLoggedIn.getInstance().updateCurrentMovieList();
                UserLoggedIn.getInstance().setCurrentPage("homepage authenticated");
                UserLoggedIn.getInstance().getPagesAccessed().add("homepage authenticated");
                return new OutputData(
                        null,
                        UserLoggedIn.getInstance().getCurrentUser(),
                        null
                );
            }
        }
        UserLoggedIn.getInstance().setCurrentPage("homepage neauthenticated");
        return new OutputData();
    }
}
