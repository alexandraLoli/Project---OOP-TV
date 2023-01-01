package factory.siteFactory;

import site.Site;
import site.homepageAuthenticated.HomepageAuthenticated;

public final class HomepageAuthenticatedFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return HomepageAuthenticated.getInstance();
    }
}
