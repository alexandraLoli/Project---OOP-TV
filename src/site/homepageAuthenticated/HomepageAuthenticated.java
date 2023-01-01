package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import site.UserLoggedIn;
import strategy.changePageStrategy.PageLogoutStrategy;
import strategy.changePageStrategy.PageMoviesStrategy;
import strategy.changePageStrategy.PageUpgradesStrategy;

import java.util.ArrayList;

public final class HomepageAuthenticated extends Site {
    private static HomepageAuthenticated instance;

    public HomepageAuthenticated() {

    }

    static {
        instance = new HomepageAuthenticated();
    }

    public static HomepageAuthenticated getInstance() {
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
            case "upgrades":
                this.changePageStrategy = new PageUpgradesStrategy();
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
        outputData.add(new OutputData());
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
