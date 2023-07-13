package it.intesys.movierater.app.DTO;

public class Movie {


    private Long id;
    private String title;
    private String director;

    private Long rating;

    public Movie() {
    }

    public Movie(Long id, String title, String director, Long rating ) {
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

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}

