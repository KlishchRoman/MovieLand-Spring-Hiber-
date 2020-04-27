package com.rk.movieland.persistence.dao;

import com.rk.movieland.domain.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreDao {

    List<Genre> findAllGenres();

    Genre findGenreByGenreId(int genre_id);

    void save(Genre genre);

    void update(Genre genre);

    void delete(Genre genre);

}
