package com.rk.movieland.web.controller;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.service.dto.MovieDto;
import com.rk.movieland.service.MovieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private static final Logger logger = LogManager.getLogger(MovieController.class);

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<MovieDto> getAllMovie() {
        logger.debug("Test MovieController");
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/random")
    public List<Movie> get3RandomMovies() {
        logger.debug("Test MovieController");
        return movieService.get3RanndomMovies();
    }

    @GetMapping(value = "genre/{genreId}")
    public List<Movie> getMovieByGenre(@PathVariable(value = "genreId") int genreId) {
        logger.debug("Test MovieController");
        return movieService.getMoviesByGenre(genreId);
    }
}
