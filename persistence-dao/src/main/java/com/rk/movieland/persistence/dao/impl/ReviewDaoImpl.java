package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.domain.Review;
import com.rk.movieland.persistence.dao.ReviewDao;
import com.rk.movieland.persistence.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    private final static ReviewMapper reviewMapper = new ReviewMapper();

    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${findAllReviewsByMovie}")
    private String findAllReviewsByMovie;

    @Value("${findReviewByReviewId}")
    private String findReviewByReviewId;

    @Override
    public List<Review> findAllReviewsByMovie(Movie movie) {
        SqlParameterSource source = new MapSqlParameterSource("movie_id", movie.getMovieId());
        return parameterJdbcTemplate.query(findAllReviewsByMovie, source, reviewMapper);
    }

    @Override
    public Review findReviewByReviewId(int review_id) {
        try {
            SqlParameterSource source = new MapSqlParameterSource("review_id", review_id);
            return parameterJdbcTemplate.queryForObject(findReviewByReviewId, source, reviewMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(Review review) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Review review) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Review review) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Autowired
    public void setParameterJdbcTemplate(NamedParameterJdbcTemplate parameterJdbcTemplate) {
        this.parameterJdbcTemplate = parameterJdbcTemplate;
    }
}
