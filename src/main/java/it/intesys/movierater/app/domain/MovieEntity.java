package it.intesys.movierater.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Director")
    private String director;

    @Column(name = "Actors")
    private String actors;

    @Column(name = "Country")
    private String country;

    @Column(name = "Rating")
    private Long rating;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

}
