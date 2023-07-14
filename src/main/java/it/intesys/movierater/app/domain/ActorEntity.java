package it.intesys.movierater.app.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "actor")
public class ActorEntity {
    @Id
    @Column(name = "ID")
    private Long id;


    @Column(name = "Actor")
    private String actor;

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
}