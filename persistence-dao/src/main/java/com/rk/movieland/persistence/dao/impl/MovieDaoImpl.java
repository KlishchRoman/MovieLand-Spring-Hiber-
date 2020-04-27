package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.domain.Movie;
import com.rk.movieland.persistence.dao.MovieDao;
import com.rk.movieland.persistence.mapper.MovieAllFieldsMapper;
import com.rk.movieland.persistence.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {
    private static final MovieMapper mapper = new MovieMapper();
    private static final MovieAllFieldsMapper allFieldsMapper = new MovieAllFieldsMapper();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${findAllMovies}")
    private String findAllMovies;

    @Value("${find3RandomMovies}")
    private String find3RandomMovies;

    @Value("${findMoviesByGenre}")
    private String findMoviesByGenre;

    @Value("${findMovieByMovieId}")
    private String findMovieByMovieId;

    @Override
    public List<Movie> findAllMovies() {
        return jdbcTemplate.query(findAllMovies, allFieldsMapper);
    }

    @Override
    public List<Movie> find3RandomMovies() {
        return jdbcTemplate.query(find3RandomMovies, mapper);
    }

    @Override
    public List<Movie> findMoviesByGenre(Genre genre) {
        SqlParameterSource source = new MapSqlParameterSource("genre_id", genre.getGenreId());
        return parameterJdbcTemplate.query(findMoviesByGenre, source, mapper);
    }

    @Override
    public Movie findMovieByMovieId(int movie_id) {
        try {
            SqlParameterSource source = new MapSqlParameterSource("movie_id", movie_id);
            return parameterJdbcTemplate.queryForObject(findMovieByMovieId, source, mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setParameterJdbcTemplate(NamedParameterJdbcTemplate parameterJdbcTemplate) {
        this.parameterJdbcTemplate = parameterJdbcTemplate;
    }
}
