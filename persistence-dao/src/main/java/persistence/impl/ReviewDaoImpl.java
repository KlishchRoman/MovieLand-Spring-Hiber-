package persistence.impl;

import domain.Movie;
import domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import persistence.dao.ReviewDao;
import persistence.mapper.ReviewMapper;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    private final ReviewMapper reviewMapper = new ReviewMapper();
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    @Value("${findAllReviewsByMovie}")
    private String findAllReviewsByMovie;

    @Value("${findReviewByReviewId}")
    private String findReviewByReviewId;

    @Override
    public List<Review> findAllReviewsByMovie(Movie movie) {
        SqlParameterSource source = new MapSqlParameterSource("movie_id", movie.getMovieId());
        List<Review> reviews = parameterJdbcTemplate.query(findAllReviewsByMovie, source, reviewMapper);
        return reviews;
    }

    @Override
    public Review findReviewByReviewId(int review_id) {
        SqlParameterSource source = new MapSqlParameterSource("review_id", review_id);
        Review review = parameterJdbcTemplate.queryForObject(findReviewByReviewId, source, reviewMapper);
        return review;
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
