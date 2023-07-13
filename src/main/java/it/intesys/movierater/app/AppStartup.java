package it.intesys.movierater.app;

import it.intesys.movierater.app.domain.MovieEntity;
import it.intesys.movierater.app.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

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
         * i primi 3 che trovo con una corrispondenza sono gli attori con carriera più lunga.
         *
         * servono 4 cicli per scorrere tutti gli elementi di entrambe le liste e devo invertire le liste terminate
         * for(l, l<dim(A1), l++)
         *  for(k,k<dim(A2), k++)
         *      for (i, i<dim(a1), i++)
         *          for(j,j<dim(a2), j++)
         *              if(a1[i]==a2[j])
         *                  add.array
         *                  if dim(array)>3
         *                  return array
         *
         *                  FUNZIONA SE GLI ANNI SONO DI DISTANZA 1
         */
    //    List<List<String>> checkdesc, checkasc;
    //    List<MovieEntity> allmoviesdesc= movieRepository.findAllByOrderByYearDesc();
//
    //    for (int i=0; i<allmoviesdesc.size(); i++ ) {
    //        checkdesc.get(i) = allmoviesdesc.get(i).getActors().split(,);
    //        checkasc.get(i) = allmoviesdesc.get(allmoviesdesc.size() - i).getActors().split(,);
    //    //associo la lista dei primi attori a checkdesc, la lista degli ultimi a checkasc
    //        for(int j=0; checkdesc.get(i)||checkasc.get(i))
    //            }
    //        }
    //    }
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> yearList = new ArrayList<>();
        Set<String> actors;
        List<MovieEntity> allmoviesdesc= movieRepository.findAll();
        for(MovieEntity iterator: allmoviesdesc ){
            actors = split(iterator.getActors()); //.split(","))
            List<String> actorList = new ArrayList<>(actors);
            for (String actor: actorList){
                if(map.keySet().contains(actor)) {
                    yearList = map.get(actor);
                    yearList.add(iterator.getYear());
                    map.replace(actor,yearList);
                }else{
                    yearList = new ArrayList<>();
                    yearList.add(iterator.getYear());
                    map.put(actor,yearList);
                }
            }


        }
        int value;
        HashMap<String, Integer> map1= new HashMap<>();
        for(String actor: map.keySet()){
            yearList=map.get(actor);
            Collections.sort(yearList, Collections.reverseOrder());
            value=yearList.get(0)- yearList.get(yearList.size()-1);
            map1.put(actor, value);
        }
        List<String> maxActors= new ArrayList<>();
        int max=0;
        String attoreScelto ="";
        for (int i=0;i<3;i++){
        for(String actor: map1.keySet()) {
            if (map1.get(actor) > max && !maxActors.contains(actor)) {
                max = map1.get(actor);
                attoreScelto = actor;
            }
        }
        maxActors.add(attoreScelto);
        max=0;
        }
        for(String topActor: maxActors) {
            log.info("Calculate actors with longest career \n "+ topActor + map1.get(topActor), "\n");
        }
       // List<Map.Entry<String,Integer>> list =  new ArrayList<Map.Entry<String, Integer>>();
       // for(String actor: map1.keySet()){
       //     list.add(actor, map1.get(actor));




    }
}