package factory.databaseFactory;

import entity.Movie;
import fileio.input.MovieInput;

public class MovieFactory extends EntityFactory {

    @Override
    public Movie createMovie
            (MovieInput movie) {
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
