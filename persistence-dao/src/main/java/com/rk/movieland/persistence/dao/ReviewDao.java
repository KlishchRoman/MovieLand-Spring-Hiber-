package com.rk.movieland.persistence.dao;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.domain.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {

    List<Review> findAllReviewsByMovie(Movie movie);

    Review findReviewByReviewId(int review_id);

    void save(Review review);

    void update(Review review);

    void delete(Review review);

}
