package domain;

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
}
