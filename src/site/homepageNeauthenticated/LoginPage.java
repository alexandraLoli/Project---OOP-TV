package site.homepageNeauthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;
import strategy.onPageStrategy.login.LoginStrategy;

import java.util.ArrayList;

public class LoginPage extends Site {
    public static LoginPage instance;

    public LoginPage() {

    }

    static {
        instance = new LoginPage();
    }

    public static LoginPage getInstance() {
        return instance;
    }

    @Override
    public void onPage(String feature, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
        switch (feature) {
            case "login":
                this.onPageStrategy = new LoginStrategy();
                break;
            default:
                this.onPageStrategy = null;
        }

        if (this.onPageStrategy == null) {
            outputData.add(new OutputData());
        } else {
            OutputData output = this.onPageStrategy.onPage(actionsInput);
            outputData.add(output);
        }
    }

    @Override
    public void back(ArrayList<OutputData> outputData, ActionsInput actionsInput) {
        super.back(outputData, actionsInput);
    }

    @Override
    public void subscribe(ArrayList<OutputData> outputData, ActionsInput actionsInput) {
        outputData.add(new OutputData());
    }
}
