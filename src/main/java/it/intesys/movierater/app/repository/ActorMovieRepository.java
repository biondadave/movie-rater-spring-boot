package it.intesys.movierater.app.repository;

import it.intesys.movierater.app.domain.ActorMovieEntity;
import it.intesys.movierater.app.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorMovieRepository extends JpaRepository<ActorMovieEntity, Long> {

}
