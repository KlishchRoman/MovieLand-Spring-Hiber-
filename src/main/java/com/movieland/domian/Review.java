package com.movieland.domian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "movie_id")
    private int movie_id;

    private int user_id;
    @Column(name = "reviewMovie")
    private String reviewMovie;

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
}
