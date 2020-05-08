package com.rk.movieland.service;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.persistence.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieDao movieDao;

    public List<Movie> getAllMovies() {
        return movieDao.findAllMovies();
    }

    public List<Movie> get3RanndomMovies() {
        return movieDao.find3RandomMovies();
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
}
