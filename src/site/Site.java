package site;

import factory.siteFactory.SiteFactoryProduce;
import fileio.input.ActionsInput;
import fileio.input.InputData;
import fileio.output.OutputData;

import java.util.ArrayList;

public class Site {

    public static void useSite(final ArrayList<OutputData> outputData,
                               final InputData inputData) {
        for (ActionsInput actionsInput : inputData.getActions()) {
            switch (actionsInput.getType()) {
                case "change page":
                    Site page = SiteFactoryProduce.getFactory(
                            UserLoggedIn.getInstance().getCurrentPage()
                    ).getPage();
                    page.changePage(actionsInput.getPage(), actionsInput, outputData);
                    break;
                case "on page":
                    page = SiteFactoryProduce.getFactory(
                            UserLoggedIn.getInstance().getCurrentPage()
                    ).getPage();
                    page.onPage(actionsInput.getFeature(), actionsInput, outputData);
                    break;
                default: break;
            }
        }
    }

    public void changePage(String pageName, ActionsInput actionsInput, ArrayList<OutputData> outputData) {

    }

    public void onPage(String feature, ActionsInput actionsInput, ArrayList<OutputData> outputData) {

    }

    public void back() {

    }
}
