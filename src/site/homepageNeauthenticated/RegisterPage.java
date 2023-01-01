package site.homepageNeauthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import strategy.onPageStrategy.register.RegisterStrategy;

import java.util.ArrayList;

public final class RegisterPage extends Site {

    private static RegisterPage instance;

    public RegisterPage() {

    }

    static {
        instance = new RegisterPage();
    }

    public static RegisterPage getInstance() {
        return instance;
    }

    @Override
    public void onPage(final String feature,
                       final ActionsInput actionsInput,
                       final ArrayList<OutputData> outputData) {
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
