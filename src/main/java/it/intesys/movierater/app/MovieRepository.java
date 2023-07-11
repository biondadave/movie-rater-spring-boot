package it.intesys.movierater.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    MovieEntity findMovieEntityById(Long id);

    List<MovieEntity> findActorsByOrderByYearDesc();

    List<MovieEntity> findActorsByOrderByYearAsc();
}
