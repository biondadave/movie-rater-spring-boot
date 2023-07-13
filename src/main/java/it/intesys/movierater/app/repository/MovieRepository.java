package it.intesys.movierater.app.repository;

import it.intesys.movierater.app.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    MovieEntity findMovieEntityById(Long id);



}
