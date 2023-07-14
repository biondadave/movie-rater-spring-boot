package it.intesys.movierater.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "actor_movie")

public class ActorMovieEntity {
        @Id
        @Column(name = "ID")
        private Long id;

        @Column(name = "Idactor")
        private long Idactor;

        @Column(name = "Idmovie")
        private long Idmovie;



        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public long getIdactor() {
                return Idactor;
        }

        public void setIdactor(long idactor) {
                Idactor = idactor;
        }

        public long getIdmovie() {
                return Idmovie;
        }

        public void setIdmovie(long idmovie) {
                Idmovie = idmovie;
        }
}
