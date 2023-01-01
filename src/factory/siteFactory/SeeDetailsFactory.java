package factory.siteFactory;

import site.Site;
import site.homepageAuthenticated.SeeDetailsPage;

public final class SeeDetailsFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return SeeDetailsPage.getInstance();
    }
}
