package factory.siteFactory;

import site.Site;
import site.homepageAuthenticated.UpgradesPage;

public final class UpgradesFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return UpgradesPage.getInstance();
    }
}
