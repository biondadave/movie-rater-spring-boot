package it.intesys.movierater.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "actor_movie")

public class ActorMovieEntity {
        @Id
        @Column(name = "ID")
        private Long id;

        @Column(name = "Actor")
        private String actor;

        @Column(name = "Idmovie")
        private Long idmovie;

        @Column(name = "Rating")
        private Long rating;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getActor() {
                return actor;
        }

        public void setActor(String actor) {
                this.actor = actor;
        }

        public Long getIdmovie() {
                return idmovie;
        }

        public void setIdmovie(Long idmovie) {
                this.idmovie = idmovie;
        }

        public Long getRating() {
                return rating;
        }

        public void setRating(Long rating) {
                this.rating = rating;
        }

}
