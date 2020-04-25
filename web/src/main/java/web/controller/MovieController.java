package web.controller;

import domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.dao.MovieDao;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    @Autowired
    MovieDao movieDao;

    @GetMapping
    public List<Movie> getAllMovie() {
        List<Movie> movies = movieDao.findAllMovies();
        return movies;
    }

}
