package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageAuthenticated.MoviesPage;

public class MoviesFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return MoviesPage.getInstance();
    }
}
