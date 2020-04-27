package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.domain.Movie;
import com.rk.movieland.persistence.dao.ApplicationTest;
import com.rk.movieland.persistence.dao.MovieDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class MovieDaoImplTest {

    @Autowired
    MovieDao movieDao;

    @Test
    void shouldReturnListAllMovies() {
        List<Movie> movies = movieDao.findAllMovies();
        assertEquals(movies.size(), 6);
    }

    @Test
    void shouldReturn3RandomMovies() {
        List<Movie> movies = movieDao.find3RandomMovies();
        assertEquals(movies.size(), 3);
    }

    @Test
    void shouldReturnListMovies_Genre() {
        List<Movie> movies = movieDao.findMoviesByGenre(new Genre(1, "драма"));
        assertEquals(movies.size(), 5);
    }

    @Test
    void shouldReturnEmptyList_IncorrectGenre() {
        List<Movie> movies = movieDao.findMoviesByGenre(new Genre(30, "без жанра"));
        assertTrue(movies.isEmpty());
    }

    @Test
    void shouldReturnMovie_MovieId() {
        Movie expectedMovie = new Movie();
        expectedMovie.setMovieId(1);
        expectedMovie.setNameRussian("Список Шиндлера");
        expectedMovie.setNameNative("Schindler's List");
        expectedMovie.setYearOfRelease(1993);
        expectedMovie.setDescription("Фильм рассказывает реальную историю загадочного Оскара Шиндлера, члена нацистской партии, преуспевающего фабриканта, спасшего во время Второй мировой войны почти 1200 евреев.");
        expectedMovie.setRating(8.7f);
        expectedMovie.setPrice(new BigDecimal("150.50"));
        expectedMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        Movie movieFromBD = movieDao.findMovieByMovieId(1);
        assertEquals(expectedMovie, movieFromBD);
    }

    @Test
    void shouldReturnNull_IncorrectMovieId() {
        Movie movieFromBD = movieDao.findMovieByMovieId(1);
        assertNull(movieFromBD);
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class,
                () -> movieDao.save(new Movie()),
                "Save not supported yet.");
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class,
                () -> movieDao.update(new Movie()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> movieDao.delete(new Movie()),
                "Delete not supported yet.");
    }
}