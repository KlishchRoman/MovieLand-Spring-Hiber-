package com.rk.movieland.persistence.dao;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao {

    List<Movie> findAllMovies();

    List<Movie> find3RandomMovies();

    List<Movie> findMoviesByGenre(int genreId);

    Movie findMovieByMovieId(int movie_id);

    void save(Movie movie);

    void update(Movie movie);

    void delete(Movie movie);

}
