package com.movieland.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void findByMovieIdBetween() {
    }


    @Test
    void loads_FromDb_NotNull() {
        long countFromDb = movieRepository.countByMovieIdIsAfter(0);
        assertThat(countFromDb).isNotNull();
    }


    @Test
    void findFirst3ByMovieIdStartingWith() {

    }
}
