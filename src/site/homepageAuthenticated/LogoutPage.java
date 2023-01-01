package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;

import java.util.ArrayList;

public final class LogoutPage extends Site {

    private static LogoutPage instance;

    public LogoutPage() {

    }

    static {
        instance = new LogoutPage();
    }

    public static LogoutPage getInstance() {
        return instance;
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
