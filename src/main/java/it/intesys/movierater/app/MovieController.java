package it.intesys.movierater.app;

import it.intesys.movierater.app.DTO.Movie;
import it.intesys.movierater.app.service.MovieService;
import org.javatuples.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final AppStartup appStartup;

    public MovieController(MovieService movieService, AppStartup appStartup) {
        this.movieService = movieService;
        this.appStartup = appStartup;
    }

    @GetMapping("/")
    public String index(Model model) {
        Pair<Movie, Movie> randomMovies = movieService.get2RandomMovies();
        model.addAttribute("movie1", randomMovies.getValue0());
        model.addAttribute("movie2", randomMovies.getValue1());
        return "index";
    }

    @ModelAttribute(name="movieCount")
    public Long movieCount() {
        appStartup.calculateActorsWithLongestCareer();
        return movieService.getMovieCount();
    }

    @ModelAttribute(name="totalVotes")
    public Long totalVotes() {
        return movieService.totalVotes();
    }

    @PostMapping("/vote")
    public String submitVote(@ModelAttribute Movie movie) {
        movieService.vote(movie.getId());
        return "redirect:/";
    }

    @GetMapping("/movie/{movieId}")
    public String getMovieDetails(@PathVariable("movieId") Long movieId) {
        return "movie";
    }
}
