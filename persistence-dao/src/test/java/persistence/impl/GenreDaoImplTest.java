package persistence.impl;

import domain.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import persistence.ApplicationTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class GenreDaoImplTest {

    @Autowired
    GenreDaoImpl genreDao;

    @Test
    void findAllGenres() {
        List<Genre> genres = genreDao.findAllGenres();
        assertFalse(genres.isEmpty());
    }

    @Test
    void findGenreByGenreId() {
        Genre genre = new Genre(1, "драма");
        Genre genreFromDb = genreDao.findGenreByGenreId(1);
        assertEquals(genre, genreFromDb);
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
                () -> genreDao.save(new Genre()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> genreDao.save(new Genre()),
                "Delete not supported yet.");
    }
}