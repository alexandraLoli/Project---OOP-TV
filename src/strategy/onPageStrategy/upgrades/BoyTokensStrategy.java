package strategy.onPageStrategy.upgrades;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public final class BoyTokensStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(final ActionsInput actionsInput) {
        String myBalance = UserLoggedIn.getInstance().getCurrentUser().getCredentials()
                .getBalance();
        Integer cost = actionsInput.getCount();
        int myTokens = UserLoggedIn.getInstance().getCurrentUser().getTokensCount();
        if (Integer.parseInt(myBalance) - cost >= 0) {
            Integer difference = Integer.parseInt(myBalance) - cost;
            myBalance = Integer.toString(difference);
            myTokens += cost;

            UserLoggedIn.getInstance().getCurrentUser().setTokensCount(myTokens);
            UserLoggedIn.getInstance().getCurrentUser().getCredentials().setBalance(myBalance);

            return null;
        }
        return new OutputData();
    }
}
