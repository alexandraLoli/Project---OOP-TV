package factory.siteFactory;

import site.Site;
import site.homepageAuthenticated.LogoutPage;

public final class LogoutFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return LogoutPage.getInstance();
    }
}
