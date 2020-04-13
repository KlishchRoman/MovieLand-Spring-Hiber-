package com.movieland.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.movieland.dao.MovieRepository;
import com.movieland.domian.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping
    @RequestMapping(path ="/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ObjectNode> getAllMovies() {
        List<ObjectNode> movies = new ArrayList<>();
        Iterable<Movie> moviesFromDB = movieRepository.findAll();
//Todo: Should I use ObjectNode jsonObject = objectMapper.createObjectNode();?
        moviesFromDB.forEach(s -> {
            ObjectNode jsonObject = objectMapper.createObjectNode();
            jsonObject.put("id", s.getMovieId());
            jsonObject.put("nameRussian", s.getNameRussian());
            jsonObject.put("nameNative", s.getNameNative());
            jsonObject.put("yearOfRelease", s.getYearOfRelease());
            jsonObject.put("rating", s.getRating());
            jsonObject.put("price", s.getPrice());
            jsonObject.put("picturePath", s.getPicturePath());
            movies.add(jsonObject);
        });
        return movies;
    }

    @GetMapping
    @RequestMapping(path ="/movie/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getRandomMovies() {
        List<Movie> movies = findThreeRandomMovies();
        return movies;
    }

    //Todo: как изменить метод так, что бы при его изменнение или замене не нужно было перекомпелировать проэкт?
    public List<Movie> findThreeRandomMovies() {
        long count = movieRepository.countByMovieIdIsAfter(0);
        int i1 = new Random().nextInt((int) (count-3));
        List<Movie> randomMovies = movieRepository.findFirst3ByMovieIdGreaterThanEqual(i1);
        return randomMovies;
    }
}
