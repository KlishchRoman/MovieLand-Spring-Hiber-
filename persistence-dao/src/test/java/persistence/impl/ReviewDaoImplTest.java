package persistence.impl;

import domain.Movie;
import domain.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import persistence.ApplicationTest;
import persistence.dao.ReviewDao;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class ReviewDaoImplTest {

    @Autowired
    private ReviewDao reviewDao;
    private List<Review> expectedReviews = new ArrayList<>();


    @BeforeEach
    public void createListReviews() {

        Review reviewOne = new Review();
        Review reviewTwo = new Review();

        reviewOne.setReviewId(1);
        reviewOne.setMovieReview("good film");
        reviewTwo.setReviewId(2);
        reviewTwo.setMovieReview("bad film");

        expectedReviews.add(reviewOne);
        expectedReviews.add(reviewTwo);
    }

    @Test
    void findAllReviewsByMovie() {
        Movie movie = new Movie();
        movie.setMovieId(1);
        List<Review> reviewsFromBD = reviewDao.findAllReviewsByMovie(movie);

        assertEquals(expectedReviews.size(), reviewsFromBD.size());
        assertEquals(expectedReviews.get(0).getMovieReview(), reviewsFromBD.get(0).getMovieReview());
    }

    @Test
    void findReviewByReviewId() {
        Review reviewFromBD = reviewDao.findReviewByReviewId(1);
        assertEquals(expectedReviews.get(0).getMovieId(), reviewFromBD.getMovieId());
        assertEquals(expectedReviews.get(0).getMovieReview(), reviewFromBD.getMovieReview());

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