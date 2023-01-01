package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageAuthenticated.LogoutPage;

public class LogoutFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return LogoutPage.getInstance();
    }
}
