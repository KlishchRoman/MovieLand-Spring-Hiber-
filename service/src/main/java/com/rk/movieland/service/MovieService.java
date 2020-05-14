package com.rk.movieland.service;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.service.dto.MovieDto;
import com.rk.movieland.persistence.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieDao movieDao;
    private MovieDto movieDto;

    public List<MovieDto> getAllMovies() {
        return movieDto.listMovieDto(movieDao.findAllMovies());
    }

    public List<Movie> get3RanndomMovies() {
        return movieDao.find3RandomMovies();
    }

    public List<Movie> getMoviesByGenre(int genreId){
        return movieDao.findMoviesByGenre(genreId);
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @Autowired
    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }
}
