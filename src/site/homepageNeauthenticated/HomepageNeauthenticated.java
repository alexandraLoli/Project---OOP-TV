package site.homepageNeauthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import strategy.changePageStrategy.ChangePageStrategy;
import strategy.changePageStrategy.PageLoginStrategy;
import strategy.changePageStrategy.PageRegisterStrategy;

import java.util.ArrayList;

public class HomepageNeauthenticated extends Site {
    public static HomepageNeauthenticated instance;
    private ChangePageStrategy changePageStrategy;

    public HomepageNeauthenticated() {

    }

    static {
        instance = new HomepageNeauthenticated();
    }

    public static HomepageNeauthenticated getInstance() {
        return instance;
    }

    @Override
    public void changePage(String pageName, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
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
            this.changePageStrategy.changePage(actionsInput);
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
