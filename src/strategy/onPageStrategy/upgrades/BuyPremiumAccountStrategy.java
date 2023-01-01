package strategy.onPageStrategy.upgrades;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

public class BuyPremiumAccountStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(ActionsInput actionsInput) {
        int myTokens = UserLoggedIn.getInstance().getCurrentUser().getTokensCount();
        if (myTokens >= 10) {
            myTokens -= 10;
            UserLoggedIn.getInstance().getCurrentUser().setTokensCount(myTokens);
            UserLoggedIn.getInstance().getCurrentUser().getCredentials().setAccountType("premium");
            return null;
        }
        return new OutputData();
    }
}
