package strategy.onPageStrategy.register;

import database.UsersDataBase;
import entity.User;
import entity.UserCredentials;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public final class RegisterStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(final ActionsInput actionsInput) {
        String name = actionsInput.getCredentials().getName();
        for (User user : UsersDataBase.getInstance().getUsers()) {
            if (user.getCredentials().getName().equals(name)) {
                UserLoggedIn.getInstance().setCurrentPage("homepage neauthenticated");
                return new OutputData();
            }
        }
        User user = new User(
                new UserCredentials(
                        actionsInput.getCredentials().getName(),
                        actionsInput.getCredentials().getPassword(),
                        actionsInput.getCredentials().getAccountType(),
                        actionsInput.getCredentials().getCountry(),
                        actionsInput.getCredentials().getBalance()),
                0,
                15
        );
        UsersDataBase.getInstance().addToUsersDB(user);
        UserLoggedIn.getInstance().setCurrentUser(user);
        UserLoggedIn.getInstance().updateCurrentMovieList();
        UserLoggedIn.getInstance().getPagesAccessed().add("homepage authenticated");
        UserLoggedIn.getInstance().setCurrentPage("homepage authenticated");
        return new OutputData(
                null,
                UserLoggedIn.getInstance().getCurrentUser(),
                null
        );
    }
}
