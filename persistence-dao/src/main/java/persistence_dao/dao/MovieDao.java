package persistence_dao.dao;

import domain.Genre;
import domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao {
    List<Movie> findAllMovies();
    List<Movie> find3RandomMovies();
    List<Movie> findMoviesByGenre(Genre genre);
    Movie findMovieByMovieId(int movie_id);

}
