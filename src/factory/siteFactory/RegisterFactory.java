package factory.siteFactory;

import site.Site;
import site.homepageNeauthenticated.RegisterPage;

public final class RegisterFactory extends SiteFactory {

    @Override
    public Site getPage() {
        return RegisterPage.getInstance();
    }
}
