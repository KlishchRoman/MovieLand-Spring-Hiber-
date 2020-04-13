package com.movieland.dao;

import com.movieland.domian.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    long countByMovieIdIsAfter(int id);
    List<Movie> findFirst3ByMovieIdGreaterThanEqual(int idStart);
}
