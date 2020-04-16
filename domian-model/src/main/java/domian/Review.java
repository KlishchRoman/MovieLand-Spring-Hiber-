package domian;

public class Review {

    private int reviewId;
    private String reviewMovie;

    private Movie movie_id;
    private User user_id;

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
