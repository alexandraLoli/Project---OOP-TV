package site.homepageNeauthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import site.UserLoggedIn;
import strategy.changePageStrategy.PageLoginStrategy;
import strategy.changePageStrategy.PageRegisterStrategy;

import java.util.ArrayList;

public final class HomepageNeauthenticated extends Site {
    private static HomepageNeauthenticated instance;

    public HomepageNeauthenticated() {

    }

    static {
        instance = new HomepageNeauthenticated();
    }

    public static HomepageNeauthenticated getInstance() {
        return instance;
    }

    @Override
    public void changePage(final String pageName,
                           final ActionsInput actionsInput,
                           final ArrayList<OutputData> outputData) {
        switch (pageName) {
            case "login":
                this.changePageStrategy = new PageLoginStrategy();
                break;
            case "register":
                this.changePageStrategy = new PageRegisterStrategy();
                break;
            default:
                this.changePageStrategy = null;
        }
        if (this.changePageStrategy == null) {
            outputData.add(new OutputData());
        } else {
            UserLoggedIn.getInstance().getPagesAccessed().add(pageName);
            this.changePageStrategy.changePage(actionsInput);
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
