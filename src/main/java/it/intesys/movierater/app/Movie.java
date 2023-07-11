package it.intesys.movierater.app;

public class Movie {


    private Long id;
    private String title;
    private String director;

    private Integer rating;

    public Movie() {
    }

    public Movie(Long id, String title, String director, Integer rating ) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rating= rating;
    }

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

