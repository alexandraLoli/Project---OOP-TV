package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import strategy.changePageStrategy.ChangePageStrategy;
import strategy.changePageStrategy.PageLogoutStrategy;
import strategy.changePageStrategy.PageMoviesStrategy;
import strategy.changePageStrategy.PageUpgradesStrategy;

import java.util.ArrayList;

public class HomepageAuthenticated extends Site {
    public static HomepageAuthenticated instance;
    private ChangePageStrategy changePageStrategy;

    public HomepageAuthenticated() {

    }

    static {
        instance = new HomepageAuthenticated();
    }

    public static HomepageAuthenticated getInstance() {
        return instance;
    }

    @Override
    public void changePage(String pageName, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
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
            OutputData output = this.changePageStrategy.changePage(actionsInput);
            if (output != null) {
                outputData.add(output);
            }
        }
    }

    @Override
    public void onPage(String feature, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
        outputData.add(new OutputData());
    }

    @Override
    public void back() {
        super.back();
    }
}
