package persistence.impl;

import domain.Genre;
import domain.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import persistence.ApplicationTest;
import persistence.dao.MovieDao;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class MovieDaoImplTest {

    @Autowired
    MovieDao movieDao;

    @Test
    void findAllMovies() {
        List<Movie> movies = movieDao.findAllMovies();
        assertFalse(movies.isEmpty());
    }

    @Test
    void find3RandomMovies() {
        List<Movie> movies = movieDao.find3RandomMovies();
        assertFalse(movies.isEmpty());
        assertEquals(movies.size(), 3);
    }
//Todo: обратить внимание на тест (как заменить new Genre() в параметрах)
    @Test
    void findMoviesByGenre() {
        List<Movie> movies = movieDao.findMoviesByGenre(new Genre(1,"драма"));
        assertEquals(movies.size(), 5);
    }

    @Test
    @DirtiesContext
    void findMovieByMovieId() {
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
    void save() {
        assertThrows(UnsupportedOperationException.class,
                () -> movieDao.save(new Movie()),
                "Save not supported yet.");
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class,
                () -> movieDao.save(new Movie()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> movieDao.save(new Movie()),
                "Delete not supported yet.");
    }
}