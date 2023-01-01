package site.homepageAuthenticated;

import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.Site;
import strategy.changePageStrategy.ChangePageStrategy;
import strategy.changePageStrategy.PageLogoutStrategy;
import strategy.changePageStrategy.PageMoviesStrategy;
import strategy.changePageStrategy.PageSeeDetailsStrategy;
import strategy.onPageStrategy.OnPageStrategy;
import strategy.onPageStrategy.movies.FilterStrategy;
import strategy.onPageStrategy.movies.SearchStrategy;

import java.util.ArrayList;

public class MoviesPage extends Site {

    public static MoviesPage instance;
    private ChangePageStrategy changePageStrategy;
    private OnPageStrategy onPageStrategy;

    public MoviesPage() {

    }

    static {
        instance = new MoviesPage();
    }

    public static MoviesPage getInstance() {
        return instance;
    }

    @Override
    public void changePage(String pageName, ActionsInput actionsInput, ArrayList<OutputData> outputData) {
        switch (pageName) {
            case "see details":
                this.changePageStrategy = new PageSeeDetailsStrategy();
                break;
            case "logout":
                this.changePageStrategy = new PageLogoutStrategy();
                break;
            case "movies":
                this.changePageStrategy = new PageMoviesStrategy();
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
            case "search":
                this.onPageStrategy = new SearchStrategy();
                break;
            case "filter":
                this.onPageStrategy = new FilterStrategy();
                break;
            default:
                this.onPageStrategy = null;
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
