package site.homepageAuthenticated;

import entity.Movie;
import entity.User;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import fileio.output.OutputUser;
import site.Site;
import site.UserLoggedIn;
import strategy.changePageStrategy.ChangePageStrategy;
import strategy.changePageStrategy.PageLoginStrategy;
import strategy.changePageStrategy.PageMoviesStrategy;
import strategy.changePageStrategy.PageUpgradesStrategy;
import strategy.onPageStrategy.OnPageStrategy;
import strategy.onPageStrategy.seeDetails.LikeStrategy;
import strategy.onPageStrategy.seeDetails.PurchaseStrategy;
import strategy.onPageStrategy.seeDetails.RateStrategy;
import strategy.onPageStrategy.seeDetails.WatchStrategy;
import strategy.specialActionStrategy.SubscribeStrategy;

import java.util.ArrayList;

public class SeeDetailsPage extends Site {

    public static SeeDetailsPage instance;

    public SeeDetailsPage() {

    }

    static {
        instance = new SeeDetailsPage();
    }

    public static SeeDetailsPage getInstance() {
        return instance;
    }

    @Override
    public void onPage(String feature, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
        switch (feature) {
            case "purchase":
                this.onPageStrategy = new PurchaseStrategy();
                break;
            case "watch":
                this.onPageStrategy = new WatchStrategy();
                break;
            case "like":
                this.onPageStrategy = new LikeStrategy();
                break;
            case "rate":
                this.onPageStrategy = new RateStrategy();
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
    public void changePage(String pageName,ActionsInput actionsInput, ArrayList<OutputData> outputData) {
        switch (pageName) {
            case "movies":
                this.changePageStrategy = new PageMoviesStrategy();
                break;
            case "upgrades":
                this.changePageStrategy = new PageUpgradesStrategy();
                break;
            case "logout":
                this.changePageStrategy = new PageLoginStrategy();
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
                if (output.getError() == null) {
                    UserLoggedIn.getInstance().getPagesAccessed().add(pageName);
                }
            }
        }
    }

    @Override
    public void back(ArrayList<OutputData> outputData, ActionsInput actionsInput) {
        super.back(outputData, actionsInput);
    }

    @Override
    public void subscribe(ArrayList<OutputData> outputData, ActionsInput actionsInput) {
        this.specialActionStrategy = new SubscribeStrategy();
        OutputData output = this.specialActionStrategy.action(actionsInput);
        if (output != null) {
            outputData.add(output);
        }
    }
}
