package it.intesys.movierater.app;

public class MovieMapper {
    public Movie toDto (MovieEntity movieEntity){
        Movie movie= new Movie();
        movie.setId(movieEntity.getId());
        movie.setDirector(movieEntity.getDirector());
        movie.setTitle(movieEntity.getTitle());
        return movie;
    }

    public MovieEntity toEntity(Movie movie){
        MovieEntity movieEntity= new MovieEntity();
        movieEntity.setId(movie.getId());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setTitle(movie.getTitle());
        return movieEntity;
    }
}
