package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import site.UserLoggedIn;
import strategy.changePageStrategy.PageLogoutStrategy;
import strategy.changePageStrategy.PageMoviesStrategy;
import strategy.onPageStrategy.upgrades.BoyTokensStrategy;
import strategy.onPageStrategy.upgrades.BuyPremiumAccountStrategy;

import java.util.ArrayList;

public final class UpgradesPage extends Site {

    private static UpgradesPage instance;

    public UpgradesPage() {

    }

    static {
        instance = new UpgradesPage();
    }

    public static UpgradesPage getInstance() {
        return instance;
    }

    @Override
    public void changePage(final String pageName,
                           final ActionsInput actionsInput,
                           final ArrayList<OutputData> outputData) {
        switch (pageName) {
            case "movies":
                this.changePageStrategy = new PageMoviesStrategy();
                break;
            case "logout":
                this.changePageStrategy = new PageLogoutStrategy();
                break;
            default:
                this.changePageStrategy = null;
        }
        if (this.changePageStrategy == null) {
            outputData.add(new OutputData());
        } else {
            UserLoggedIn.getInstance().getPagesAccessed().add(pageName);
            OutputData output = this.changePageStrategy.changePage(actionsInput);
            if (output != null) {
                outputData.add(output);
            }
        }
    }

    @Override
    public void onPage(final String feature,
                       final ActionsInput actionsInput,
                       final ArrayList<OutputData> outputData) {
        switch (feature) {
            case "buy premium account":
                this.onPageStrategy = new BuyPremiumAccountStrategy();
                break;
            case "buy tokens":
                this.onPageStrategy = new BoyTokensStrategy();
                break;
            default:
                this.onPageStrategy = null;
        }

        if (this.onPageStrategy == null) {
            outputData.add(new OutputData());
        } else {
            OutputData output = this.onPageStrategy.onPage(actionsInput);
            if (output != null) {
                outputData.add(output);
            }
        }
    }

    @Override
    public void back(final ArrayList<OutputData> outputData,
                     final ActionsInput actionsInput) {
        super.back(outputData, actionsInput);
    }

    @Override
    public void subscribe(final ArrayList<OutputData> outputData,
                          final ActionsInput actionsInput) {
        outputData.add(new OutputData());
    }
}
