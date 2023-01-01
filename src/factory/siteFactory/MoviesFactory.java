package factory.siteFactory;

import site.Site;
import site.homepageAuthenticated.MoviesPage;

public final class MoviesFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return MoviesPage.getInstance();
    }
}
