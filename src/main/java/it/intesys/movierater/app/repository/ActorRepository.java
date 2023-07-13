package it.intesys.movierater.app.repository;

import it.intesys.movierater.app.domain.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {


}