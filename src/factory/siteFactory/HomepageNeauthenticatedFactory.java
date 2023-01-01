package factory.siteFactory;

import site.Site;
import site.homepageNeauthenticated.HomepageNeauthenticated;

public final class HomepageNeauthenticatedFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return HomepageNeauthenticated.getInstance();
    }
}
