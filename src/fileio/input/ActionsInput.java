package fileio.input;

public final class ActionsInput {
    private String type;
    private String page;
    private String movie;
    private CredentialsInput credentials;
    private FiltersInput filters;
    private String startsWith;
    private String feature;
    private Integer count;
    private Integer rate;
    private String subscribedGenre;
    private MovieInput addedMovie;
    private String deletedMovie;

    public ActionsInput() {

    }

    public String getType() {
        return type;
    }

    public String getPage() {
        return page;
    }

    public String getMovie() {
        return movie;
    }

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public FiltersInput getFilters() {
        return filters;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public String getFeature() {
        return feature;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getRate() {
        return rate;
    }

    public String getSubscribedGenre() {
        return subscribedGenre;
    }

    public MovieInput getAddedMovie() {
        return addedMovie;
    }

    public String getDeletedMovie() {
        return deletedMovie;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setPage(final String page) {
        this.page = page;
    }

    public void setMovie(final String movie) {
        this.movie = movie;
    }

    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public void setFilters(final FiltersInput filtersInput) {
        this.filters = filtersInput;
    }

    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    public void setFeature(final String feature) {
        this.feature = feature;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }

    public void setRate(final Integer rate) {
        this.rate = rate;
    }

    public void setSubscribedGenre(final String subscribedGenre) {
        this.subscribedGenre = subscribedGenre;
    }

    public void setAddedMovie(final MovieInput addedMovie) {
        this.addedMovie = addedMovie;
    }

    public void setDeletedMovie(final String deletedMovie) {
        this.deletedMovie = deletedMovie;
    }

    @Override
    public String toString() {
        return "ActionsInput{"
                + "type='" + type + '\''
                + ", page='" + page + '\''
                + ", movie='" + movie + '\''
                + ", credentials=" + credentials
                + ", filtersInput=" + filters
                + ", startsWith='" + startsWith + '\''
                + ", feature='" + feature + '\''
                + ", count=" + count
                + ", rate=" + rate
                + '}';
    }
}
