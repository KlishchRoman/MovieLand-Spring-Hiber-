package persistence_dao.daoImpl;

import domain.Movie;
import domain.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import persistence_dao.ApplicationTest;
import persistence_dao.dao.ReviewDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class ReviewDaoImplTest {

    @Autowired
    private ReviewDao reviewDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    List<Review> expectedReview;


    @Test
    void findAllReviewsByMovie() {
        Movie movie = new Movie();
        ReflectionTestUtils.setField(movie, "movieId", 1);
        List<Review> reviewsFromDB = reviewDao.findAllReviewsByMovie(movie);

        when(expectedReview.size()).thenReturn(2);
        when(expectedReview.get(0).getReviewMovie()).thenReturn("good film");

        assertEquals(reviewsFromDB.get(0).getReviewMovie(), expectedReview.get(0).getReviewMovie());
        assertEquals(reviewsFromDB.size(), expectedReview.size());

    }

    @Test
    void findReviewByReviewId() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}