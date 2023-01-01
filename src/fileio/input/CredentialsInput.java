package fileio.input;

public final class CredentialsInput {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public CredentialsInput() {

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

    public void setName(final String name) {
        this.name = name;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setBalance(final String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserInput{"
                + "name='" + name + '\''
                + ", password='" + password + '\''
                + ", accountType='" + accountType + '\''
                + ", country='" + country + '\''
                + ", balance=" + balance
                + '}';
    }
}
