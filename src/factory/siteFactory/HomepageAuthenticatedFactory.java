package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageAuthenticated.HomepageAuthenticated;

public class HomepageAuthenticatedFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return HomepageAuthenticated.getInstance();
    }
}
