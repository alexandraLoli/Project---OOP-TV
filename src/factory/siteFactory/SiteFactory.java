package factory.siteFactory;

import site.Site;

public abstract class SiteFactory {
    /**
     * Return the instance of a page
     * @return
     */
    public abstract Site getPage();
}
