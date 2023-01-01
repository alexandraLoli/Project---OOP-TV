package site.homepageNeauthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import strategy.onPageStrategy.login.LoginStrategy;

import java.util.ArrayList;

public final class LoginPage extends Site {
    private static LoginPage instance;

    public LoginPage() {

    }

    static {
        instance = new LoginPage();
    }

    public static LoginPage getInstance() {
        return instance;
    }

    @Override
    public void onPage(final String feature,
                       final ActionsInput actionsInput,
                       final ArrayList<OutputData> outputData) {
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
