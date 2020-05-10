package com.rk.movieland.web.controller;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.service.GenreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/genre", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenreController {
    private static final Logger logger = LogManager.getRootLogger();
    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenre(){
        logger.debug("Test GenreController");
        return genreService.getAllGenre();
    }
}
