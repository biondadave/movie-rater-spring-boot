package it.intesys.movierater.app.service;

import it.intesys.movierater.app.DTO.Movie;
import it.intesys.movierater.app.domain.ActorEntity;
import it.intesys.movierater.app.domain.ActorMovieEntity;
import it.intesys.movierater.app.domain.MovieEntity;
import it.intesys.movierater.app.mapper.MovieMapper;
import it.intesys.movierater.app.repository.ActorMovieRepository;
import it.intesys.movierater.app.repository.ActorRepository;
import it.intesys.movierater.app.repository.MovieRepository;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.hibernate.boot.model.source.internal.hbm.CommaSeparatedStringHelper.split;

@Service
public class MovieService {

    public final MovieRepository movieRepository;

    public final ActorMovieRepository actorMovieRepository;

    public final ActorRepository actorRepository;
    public final MovieMapper movieMapper;


    public MovieService(MovieRepository movieRepository, ActorMovieRepository actorMovieRepository, ActorRepository actorRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.actorMovieRepository = actorMovieRepository;
        this.actorRepository = actorRepository;
        this.movieMapper = movieMapper;
    }

    private final Logger logger = LoggerFactory.getLogger(MovieService.class);

    /**
     * task 2
     *
     * @return
     */
    public Pair<Movie, Movie> get2RandomMovies() {
        Long range = getMovieCount();
        Long rand1 = (long) (Math.random() * range + 1);
        Long rand2 = (long) (Math.random() * (range) + 1);
        return Pair.with(
                movieMapper.toDto(movieRepository.findMovieEntityById(rand1)),
                movieMapper.toDto(movieRepository.findMovieEntityById(rand2)));
    }

    /**
     * task 1
     *
     * @return
     */
    public Long getMovieCount() {
        Long total = movieRepository.count();
        return total;
    }

    /**
     * task 3,scorro lista in un foreach,
     * se null darebbe errore quindi metto la condizione per evitarlo,
     * salvo nel db
     *
     * @param movieId
     */
    public void vote(Long movieId) {
        MovieEntity ratedEntity = movieRepository.findMovieEntityById(movieId);
        Long currentRating = ratedEntity.getRating();
        if (currentRating == null)
            ratedEntity.setRating(1L);
        else
            ratedEntity.setRating(currentRating + 1L);
        movieRepository.save(ratedEntity);
        logger.info("total vote for movie {}", ratedEntity.getRating());
    }

    /**
     * task 5 scorro con un foreach, se null darebbe errore quindi if, sommo al totale inizializzato a 0
     *
     * @return
     */
    public Long totalVotes() {
        List<MovieEntity> entityList = movieRepository.findAll();
        Long total = 0l;
        for (MovieEntity ratingEntity : entityList) {
            if (ratingEntity.getRating() != null)
                total = ratingEntity.getRating() + total;
        }
        return total;
    }

}
   // public void actorMigration() {
   //     ActorEntity migrationActor = new ActorEntity();
   //     Set<String> actors;
//
   //     List<ActorMovieEntity> migrationList = actorMovieRepository.findAll();
   //     Long id = 1L;
   //     for (ActorMovieEntity migrationEntity :
   //             migrationList) {
   //         migrationActor.setId(id);
   //         migrationActor
   //         if (migrationEntity.getRating() == null)
   //             migrationActor.setRating(0L);
   //         else migrationActor.setRating(migrationEntity.getRating());
   //         migrationActor.setYear(migrationEntity.getYear());
   //         actors = split(migrationEntity.getActors());
   //         List<String> actorList = new ArrayList<>(actors);
   //         //converting map to list of string
   //         for (String actor : actorList) {
   //             migrationActor.setId(id);
   //             migrationActor.setActor(actor);
   //             actorMovieRepository.save(migrationActor);
   //         }
   //     }
   // }
