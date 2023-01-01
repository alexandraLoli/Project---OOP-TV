package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageAuthenticated.SeeDetailsPage;

public class SeeDetailsFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return SeeDetailsPage.getInstance();
    }
}
