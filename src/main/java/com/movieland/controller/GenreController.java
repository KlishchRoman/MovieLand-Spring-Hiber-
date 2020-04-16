package com.movieland.controller;

import com.movieland.dao.GenreRepository;
import com.movieland.dao.MovieRepository;
import domain.Genre;
import domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController

public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    @RequestMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/movie/genre/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMoviesByGenre(@PathVariable(name = "genreId") Long id,
                                        @RequestParam(required = false) String rating,
                                        @RequestParam(required = false) String price) {
        List<Movie> movies;
        if (rating != null && rating.equals("DESC")) {
            movies = movieRepository.findMoviesByGenre(id)
                    .stream().sorted(Comparator.comparing(Movie::getRating))
                    .collect(Collectors.toList());
            return movies;
        }
        if (price != null && price.equals("DESC")) {
            movies = movieRepository.findMoviesByGenre(id)
                    .stream().sorted(Comparator.comparing(Movie::getPrice))
                    .collect(Collectors.toList());
            return movies;
        }
        if (price != null && price.equals("ASC")) {
            movies = movieRepository.findMoviesByGenre(id)
                    .stream().sorted(Comparator.comparing(Movie::getPrice).reversed())
                    .collect(Collectors.toList());
            return movies;
        } else
            movies = movieRepository.findMoviesByGenre(id);
        return movies;
    }
}
