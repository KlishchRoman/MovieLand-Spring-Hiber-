package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Movie;
import com.rk.movieland.domain.Review;
import com.rk.movieland.persistence.dao.ApplicationTest;
import com.rk.movieland.persistence.dao.ReviewDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class ReviewDaoImplTest {

    @Autowired
    private ReviewDao reviewDao;

    @Test
    void shouldReturnAllReviews_Movie() {
        Movie movie = new Movie();
        movie.setMovieId(1);
        List<Review> reviewsFromBD = reviewDao.findAllReviewsByMovie(movie);
        assertEquals(reviewsFromBD.size(), 2);
    }

    @Test
    void shouldReturnReview_ReviewId() {
        Review expectedReview = new Review();
        expectedReview.setReviewId(1);

        Review reviewFromBD = reviewDao.findReviewByReviewId(1);
        assertEquals(expectedReview.getReviewId(),reviewFromBD.getReviewId());
    }
    @Test
    void shouldReturnNull_IncorrectReviewId() {
        Review expectedReview = new Review();
        expectedReview.setReviewId(1);

        Review reviewFromBD = reviewDao.findReviewByReviewId(15);
        assertNull(reviewFromBD);
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class,
                () -> reviewDao.save(new Review()),
                "Save not supported yet.");
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class,
                () -> reviewDao.update(new Review()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> reviewDao.delete(new Review()),
                "Delete not supported yet.");
    }
}