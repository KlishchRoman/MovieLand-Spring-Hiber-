package com.movieland.dao;

import com.movieland.domian.Genre;
import com.movieland.domian.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    long countByMovieIdIsAfter(int id);

    List<Movie> findFirst3ByMovieIdGreaterThanEqual(int idStart);

    @Query(value = "select * from movies_genres mg join movies m on m.movie_id = mg.movie_id where mg.genre_id = :genre_id", nativeQuery = true)
    List<Movie> findMoviesByGenre(@Param("genre_id") Long id);

    List<Movie> findAll(Sort rating);

    List<Movie> findAll();
}
