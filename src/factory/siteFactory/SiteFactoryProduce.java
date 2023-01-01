package factory.siteFactory;

public class SiteFactoryProduce {
    /**
     * Return a specific factory to get a page later
     * @param type for page type
     * @return needed factory
     */
    public static SiteFactory getFactory(final String type) {
        if ("homepage authenticated".equals(type)) {
            return new HomepageAuthenticatedFactory();
        } else if ("homepage neauthenticated".equals(type)) {
            return new HomepageNeauthenticatedFactory();
        } else if ("login".equals(type)) {
            return new LoginFactory();
        } else if ("register".equals(type)) {
            return new RegisterFactory();
        } else if ("movies".equals(type)) {
            return new MoviesFactory();
        } else if ("see details".equals(type)) {
            return new SeeDetailsFactory();
        } else if ("upgrades".equals(type)) {
            return new UpgradesFactory();
        } else {
            return new LogoutFactory();
        }
    }
}
