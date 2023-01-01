package factory.databaseFactory;

import entity.Movie;
import fileio.input.MovieInput;

public class MovieFactory extends EntityFactory {

    /**
     * Convert parameter MovieInput to Movie
     * @param movie
     * @return
     */
    @Override
    public Movie createMovie(final MovieInput movie) {
        return new Movie(
                movie.getName(),
                movie.getYear(),
                movie.getDuration(),
                movie.getGenres(),
                movie.getActors(),
                movie.getCountriesBanned()
        );
    }
}
