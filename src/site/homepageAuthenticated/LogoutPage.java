package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;

import java.util.ArrayList;

public class LogoutPage extends Site {

    public static LogoutPage instance;

    public LogoutPage() {

    }

    static {
        instance = new LogoutPage();
    }

    public static LogoutPage getInstance() {
        return instance;
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
