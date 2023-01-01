package strategy.onPageStrategy.movies;

import database.MoviesDataBase;
import entity.Movie;
import fileio.input.ActionsInput;
import fileio.output.OutputData;
import site.UserLoggedIn;
import strategy.onPageStrategy.OnPageStrategy;

import java.util.Collections;
import java.util.Comparator;

public class FilterStrategy implements OnPageStrategy {
    @Override
    public OutputData onPage(ActionsInput actionsInput) {
        UserLoggedIn.getInstance().updateCurrentMovieList();
        if (actionsInput.getFilters().getContains() != null) {
            if (actionsInput.getFilters().getContains().getActors() != null) {
                filterByActors(actionsInput);
            }
            if (actionsInput.getFilters().getContains().getGenre() != null) {
                filterByGenres(actionsInput);
            }
        }
        if (actionsInput.getFilters().getSort() != null) {
            if (actionsInput.getFilters().getSort().getRating() != null) {
                if (actionsInput.getFilters().getSort().getDuration() != null) {
                    filterByRatingAndDuration(actionsInput);
                }
                else {
                    filterByRating(actionsInput);
                }
            } else {
                filterByDuration(actionsInput);
            }
        }
        return new OutputData(
                null,
                UserLoggedIn.getInstance().getCurrentUser(),
                UserLoggedIn.getInstance().getCurrentMovieList()
        );
    }

    private void filterByActors(ActionsInput actionsInput) {
        for (Movie movie : MoviesDataBase.getInstance().getMovies()) {
            int actorsToHave = 0;
            int actorsIHave = 0;
            for (String actor : actionsInput.getFilters().getContains().getActors()) {
                actorsToHave++;
                for (String act : movie.getActors()) {
                    if (act.equals(actor)) {
                        actorsIHave++;
                        break;
                    }
                }
            }

            if (actorsToHave != actorsIHave) {
                UserLoggedIn.getInstance().getCurrentMovieList().remove(movie);
            }
        }
    }

    public void filterByGenres(ActionsInput actionsInput) {
        for (Movie movie : MoviesDataBase.getInstance().getMovies()) {
            int genresToHave = 0;
            int genresIHave = 0;
            for (String genre : actionsInput.getFilters().getContains().getGenre()) {
                genresToHave++;
                for (String gen : movie.getGenres()) {
                    if (gen.equals(genre)) {
                        genresIHave++;
                        break;
                    }
                }
            }

            if (genresIHave != genresToHave) {
                UserLoggedIn.getInstance().getCurrentMovieList().remove(movie);
            }
        }
    }

    public void filterByRating(ActionsInput actionsInput) {
        switch (actionsInput.getFilters().getSort().getRating()) {
            case "decreasing":
                Collections.sort(
                        UserLoggedIn.getInstance().getCurrentMovieList(),
                        Comparator.comparing(Movie::getRating).reversed()
                );
                break;
            case "increasing":
                Collections.sort(
                        UserLoggedIn.getInstance().getCurrentMovieList(),
                        Comparator.comparing(Movie::getRating)
                );
                break;
            default:
                break;
        }
    }

    public void filterByDuration(ActionsInput actionsInput) {
        switch (actionsInput.getFilters().getSort().getDuration()) {
            case "decreasing":
                Collections.sort(
                        UserLoggedIn.getInstance().getCurrentMovieList(),
                        Comparator.comparing(Movie::getDuration).reversed()
                );
                break;
            case "increasing":
                Collections.sort(
                        UserLoggedIn.getInstance().getCurrentMovieList(),
                        Comparator.comparing(Movie::getDuration)
                );
            default:
                break;
        }
    }

    public void filterByRatingAndDuration(ActionsInput actionsInput) {
        filterByRating(actionsInput);
        filterByDuration(actionsInput);
    }
}
