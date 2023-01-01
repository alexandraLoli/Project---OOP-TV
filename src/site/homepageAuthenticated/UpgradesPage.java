package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import strategy.changePageStrategy.ChangePageStrategy;
import strategy.changePageStrategy.PageLogoutStrategy;
import strategy.changePageStrategy.PageMoviesStrategy;
import strategy.onPageStrategy.OnPageStrategy;
import strategy.onPageStrategy.upgrades.BoyTokensStrategy;
import strategy.onPageStrategy.upgrades.BuyPremiumAccountStrategy;

import java.util.ArrayList;

public class UpgradesPage extends Site {

    public static UpgradesPage instance;
    private ChangePageStrategy changePageStrategy;
    private OnPageStrategy onPageStrategy;

    public UpgradesPage() {

    }

    static {
        instance = new UpgradesPage();
    }

    public static UpgradesPage getInstance() {
        return instance;
    }

    @Override
    public void changePage(String pageName, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
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
            OutputData output = this.changePageStrategy.changePage(actionsInput);
            if (output != null) {
                outputData.add(output);
            }
        }
    }

    @Override
    public void onPage(String feature, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
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

        if (this.onPageStrategy == null)
            outputData.add(new OutputData());
        else {
            OutputData output = this.onPageStrategy.onPage(actionsInput);
            if (output != null) {
                outputData.add(output);
            }
        }
    }

    @Override
    public void back() {
        super.back();
    }
}
