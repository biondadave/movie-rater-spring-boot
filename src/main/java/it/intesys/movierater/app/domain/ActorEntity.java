package it.intesys.movierater.app.domain;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class ActorEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Career")
    private Integer career;

    @Column(name = "Rating")
    private Long rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
