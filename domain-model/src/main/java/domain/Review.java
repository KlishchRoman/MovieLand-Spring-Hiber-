package domain;

import java.util.Objects;

public class Review {

    private int reviewId;
    private String reviewMovie;

    private Movie movie_id;
    private User user_id;

    public Review() {
    }

    public Review(int reviewId, String reviewMovie, Movie movie_id, User user_id) {
        this.reviewId = reviewId;
        this.reviewMovie = reviewMovie;
        this.movie_id = movie_id;
        this.user_id = user_id;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewMovie() {
        return reviewMovie;
    }

    public void setReviewMovie(String reviewMovie) {
        this.reviewMovie = reviewMovie;
    }

    public Movie getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Movie movie_id) {
        this.movie_id = movie_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewMovie='" + reviewMovie + '\'' +
                ", movie_id=" + movie_id +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId &&
                Objects.equals(reviewMovie, review.reviewMovie) &&
                Objects.equals(movie_id, review.movie_id) &&
                Objects.equals(user_id, review.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, reviewMovie, movie_id, user_id);
    }
}
