package factory.databaseFactory;

import entity.User;
import entity.UserCredentials;
import fileio.input.UserInput;

public class UserFactory extends EntityFactory {

    @Override
    public User createUser(UserInput user) {
        return new User(
                new UserCredentials(
                        user.getCredentials().getName(),
                        user.getCredentials().getPassword(),
                        user.getCredentials().getAccountType(),
                        user.getCredentials().getCountry(),
                        user.getCredentials().getBalance()
                ),
                0,
                15
        );
    }
}
