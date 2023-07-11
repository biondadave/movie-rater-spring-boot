package it.intesys.movierater.app;

import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Long rand1= (long)(Math.random()*range+1);
        Long rand2= (long)(Math.random()*(range)+1);
        return Pair.with(
               movieMapper.toDto(movieRepository.findMovieEntityById(rand1)),
               movieMapper.toDto(movieRepository.findMovieEntityById(rand2)));
    }

    public Long getMovieCount(){
        Long total =movieRepository.count();
        return total;
    }

    public void vote(Long movieId) {
        MovieEntity ratedEntity =movieRepository.findMovieEntityById(movieId);
        Integer currentRating=ratedEntity.getRating();
        if(currentRating==null)
            ratedEntity.setRating(1);
        else
        ratedEntity.setRating(currentRating+1);
        movieRepository.save(ratedEntity);
        logger.info("total vote for movie {}", ratedEntity.getRating());
    }
    public Long totalVotes(){
        List<MovieEntity> entityList=movieRepository.findAll();
        Long total=0l;
        for (MovieEntity ratingEntity: entityList) {
            if (ratingEntity.getRating() != null)
                total = ratingEntity.getRating() + total;
        }
        return total;
    }

}
