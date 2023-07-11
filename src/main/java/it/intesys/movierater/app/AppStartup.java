package it.intesys.movierater.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hibernate.boot.model.source.internal.hbm.CommaSeparatedStringHelper.split;

@Component
public class AppStartup {

    public final MovieRepository movieRepository;

    private final Logger log = LoggerFactory.getLogger(AppStartup.class);


    public AppStartup(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @EventListener(ApplicationReadyEvent.class)

    public void calculateActorsWithLongestCareer() {
        /**
         * sorto il db per data di uscita del film, guardo il primo e l'ultimo film,
         * i primi 3 che trovo con una corrispondenza sono gli attori con carriera più lunga
         */
    //   List<MovieEntity> moviesdesc = movieRepository.findActorsByOrderByYearDesc();
    //    List<MovieEntity> moviesasc = movieRepository.findActorsByOrderByYearAsc();
    //    List<List<String>> listOfActorsAsc;
    //    List<List<String>> listOfActorsDesc;
    //    for (moviesasc:
    //         moviesdesc) {
    //        listOfActorsAsc=split(moviesasc.getActors());
    //        listOfActorsDesc=split(moviesdesc.getActors());
    //        for (listOfActorsAsc:
    //             listOfActorsDesc) {
    //            if(listOfActorsAsc.get())
    //        }
        }




      //  log.info("Calculate actors with longest career");
    }
