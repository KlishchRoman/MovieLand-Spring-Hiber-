package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.persistence.dao.GenreDao;
import com.rk.movieland.persistence.mapper.GenreMapper;
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
public class GenreDaoImpl implements GenreDao {
    private static final GenreMapper genremaper = new GenreMapper();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${queryFindAllGenres}")
    private String queryFindAllGenres;

    @Value("${queryFindGenreByGenreId}")
    private String queryFindGenreByGenreId;

    @Override
    public List<Genre> findAllGenres() {
        return jdbcTemplate.query(queryFindAllGenres, genremaper);
    }

    @Override
    public Genre findGenreByGenreId(int genre_id) {
        try {
            SqlParameterSource source = new MapSqlParameterSource("genre_id", genre_id);
            return parameterJdbcTemplate.queryForObject(queryFindGenreByGenreId, source, genremaper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Genre genre) {
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
