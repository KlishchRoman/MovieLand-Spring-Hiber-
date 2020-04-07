package com.movieland.domian;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private int reviewId;
    //TODO: @JoinColumn?
    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie_id;
    //TODO: cascade = CascadeType.***? @JoinColumn?

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(name = "reviewMovie",nullable = false)
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
