package com.rk.movieland.service;

import com.rk.movieland.domain.Genre;
import com.rk.movieland.persistence.dao.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private GenreDao genreDao;

    public List<Genre> getAllGenre(){
        return genreDao.findAllGenres();
    }

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
