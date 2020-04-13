package com.movieland.controller;

import com.movieland.dao.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenreController {

    @Autowired
    GenreRepository genreRepository;
}
