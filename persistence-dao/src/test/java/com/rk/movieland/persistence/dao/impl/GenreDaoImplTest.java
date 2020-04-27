package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.persistence.dao.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class GenreDaoImplTest {

    @Autowired
    GenreDaoImpl genreDao;

    @Test
    void shouldReturnListAllGenres() {
        List<Genre> genres = genreDao.findAllGenres();
        assertEquals(genres.size(), 15);
    }

    @Test
    void shouldReturnGenre_GenreId() {
        Genre expectedGenre = new Genre(1, "драма");
        Genre genreFromDb = genreDao.findGenreByGenreId(1);
        assertEquals(expectedGenre, genreFromDb);
    }

    @Test
    void shouldReturnNull_IncorrectId() {
        Genre genreFromDb = genreDao.findGenreByGenreId(20);
        assertNull(genreFromDb);
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class,
                () -> genreDao.save(new Genre()),
                "Save not supported yet.");
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class,
                () -> genreDao.update(new Genre()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> genreDao.delete(new Genre()),
                "Delete not supported yet.");
    }
}