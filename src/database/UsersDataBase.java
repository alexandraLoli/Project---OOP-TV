package database;

import entity.User;

import java.util.ArrayList;

public final class UsersDataBase {

    private static UsersDataBase instance;
    private final ArrayList<User> users;

    public UsersDataBase() {
        this.users = new ArrayList<>();
    }

    static {
        instance = new UsersDataBase();
    }

    /* Getters */

    public static UsersDataBase getInstance() {
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Adds user to database
     * @param user - the user we want to add to data base
     */
    public void addToUsersDB(final User user) {
        users.add(user);
    }

    /**
     * Resets database
     */
    public void reset() {
        instance = new UsersDataBase();
    }

    @Override
    public String toString() {
        return "UsersDataBase{"
                + "users=" + users
                + '}';
    }
}
