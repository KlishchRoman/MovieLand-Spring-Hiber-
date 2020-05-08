package com.rk.movieland.web.controller;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovie() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/random")
    public List<Movie> get3RandomMovie() {
        return movieService.get3RanndomMovies();
    }
}
