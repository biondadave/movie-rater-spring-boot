package it.intesys.movierater.app;

import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MovieService {

    public final MovieRepository movieRepository;
    public final MovieMapper movieMapper;
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    private final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public Pair<Movie, Movie> get2RandomMovies() {
        Long range= getMovieCount();
        Random random= new Random();
        Long rand1= random.nextLong()*range+1;
        Long rand2= random.nextLong()*range+1;

        return Pair.with(
                movieMapper.toDto(movieRepository.findMovieEntitiesById(rand1)),
                movieMapper.toDto(movieRepository.findMovieEntitiesById(rand2)));
    }

    /**
     * if delete will ever be added this won't work anymore
     * @return
     */
    public Long getMovieCount(){
        Movie movie= movieMapper.toDto(movieRepository.findFirstByOrderByIdDesc());
        return movie.getId();
    }

    public void vote(Long movieId) {
        logger.info("Add vote for movie {}", movieId);
    }
}
