package persistence_dao.dao;

import domain.Movie;
import domain.Review;
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
