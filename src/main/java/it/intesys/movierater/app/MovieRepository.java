package it.intesys.movierater.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{
 MovieEntity findFirstByOrderByIdDesc();
 MovieEntity findMovieEntitiesById(Long id);
}
