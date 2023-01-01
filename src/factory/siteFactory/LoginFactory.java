package factory.siteFactory;

import site.Site;
import site.homepageNeauthenticated.LoginPage;

public final class LoginFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return LoginPage.getInstance();
    }
}
