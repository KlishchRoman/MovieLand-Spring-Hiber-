package com.movieland.domian;

import javax.persistence.*;

@Entity
@Table(name = "posters")
public class Poster {

    @Id
    @Column(name = "movie_id")
    @OneToOne(targetEntity = "movies",orphanRemoval=true)
    private int movieId;

    @Column(name = "urlPoster")
    private String picturePath;
}
