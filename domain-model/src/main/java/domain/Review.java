package domain;

import java.util.Objects;

public class Review {

    private int reviewId;
    private String movieReview;

    private Movie movieId;
    private User userId;

    public Review() {
    }

    public Review(int reviewId, String movieReview, Movie movieId, User userId) {
        this.reviewId = reviewId;
        this.movieReview = movieReview;
        this.movieId = movieId;
        this.userId = userId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewMovie='" + movieReview + '\'' +
                ", movie_id=" + movieId +
                ", user_id=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId &&
                Objects.equals(movieReview, review.movieReview) &&
                Objects.equals(movieId, review.movieId) &&
                Objects.equals(userId, review.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, movieReview, movieId, userId);
    }
}
