package persistence_dao.dao;

import domain.Movie;
import domain.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao {
    List<Review> findAllReviewsByMovie(Movie movie);
    List<Review> findReviewByReviewId(int review_id);

}
