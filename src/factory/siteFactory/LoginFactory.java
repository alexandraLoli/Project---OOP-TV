package factory.siteFactory;

import fileio.output.OutputData;
import site.Site;
import site.homepageNeauthenticated.LoginPage;

public class LoginFactory extends SiteFactory{

    @Override
    public Site getPage() {
        return LoginPage.getInstance();
    }
}
