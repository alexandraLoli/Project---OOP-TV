package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageAuthenticated.UpgradesPage;

public class UpgradesFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return UpgradesPage.getInstance();
    }
}
