package entity;

public final class UserCredentials {
    private final String name;
    private final String password;
    private String accountType;
    private final String country;
    private String balance;


    public UserCredentials(final String name,
                           final String password,
                           final String accountType,
                           final String country,
                           final String balance) {
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getCountry() {
        return country;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(final String balance) {
        this.balance = balance;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "UserCredentials{"
                + "name='" + name + '\''
                + ", password='" + password + '\''
                + ", accountType='" + accountType + '\''
                + ", country='" + country + '\''
                + ", balance=" + balance
                + '}';
    }
}
