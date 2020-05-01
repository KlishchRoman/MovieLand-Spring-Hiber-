package com.rk.movieland.web.controller;


import com.rk.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String getAllMovie() {

        return "Hello";
    }
}
