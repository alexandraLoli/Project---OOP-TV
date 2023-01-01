package site.homepageNeauthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;
import strategy.onPageStrategy.register.RegisterStrategy;

import java.util.ArrayList;

public class RegisterPage extends Site {

    public static RegisterPage instance;
    private OnPageStrategy onPageStrategy;

    public RegisterPage() {

    }

    static {
        instance = new RegisterPage();
    }

    public static RegisterPage getInstance() {
        return instance;
    }

    @Override
    public void onPage(String feature, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
        switch (feature) {
            case "register":
                this.onPageStrategy = new RegisterStrategy();
                break;
            default: this.onPageStrategy = null;
        }
        if (this.onPageStrategy == null) {
            outputData.add(new OutputData());
        } else {
            outputData.add(this.onPageStrategy.onPage(actionsInput));
        }
    }

    @Override
    public void back() {
        super.back();
    }

}
