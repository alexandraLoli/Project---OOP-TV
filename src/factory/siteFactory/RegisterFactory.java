package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageNeauthenticated.RegisterPage;

public class RegisterFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return RegisterPage.getInstance();
    }
}
