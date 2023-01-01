package fileio.input;

public final class FiltersInput {
    private SortInput sort;
    private ContainsInput contains;

    public FiltersInput() {

    }

    public SortInput getSort() {
        return sort;
    }

    public ContainsInput getContains() {
        return contains;
    }

    public void setSort(final SortInput sort) {
        this.sort = sort;
    }

    public void setContains(final ContainsInput contains) {
        this.contains = contains;
    }

    @Override
    public String toString() {
        return "FiltersInput{"
                + "sort=" + sort
                + ", contains=" + contains
                + '}';
    }
}
