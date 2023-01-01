package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageNeauthenticated.HomepageNeauthenticated;

public class HomepageNeauthenticatedFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return HomepageNeauthenticated.getInstance();
    }
}
