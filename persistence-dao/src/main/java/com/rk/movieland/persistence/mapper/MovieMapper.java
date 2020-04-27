package com.rk.movieland.persistence.mapper;

import com.rk.movieland.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setNameRussian(rs.getString("name_russian"));
        movie.setNameNative(rs.getString("name_native"));
        movie.setYearOfRelease(rs.getInt("year_of_release"));
        movie.setDescription(rs.getString("description"));
        movie.setRating(rs.getFloat("rating"));
        movie.setPrice(rs.getBigDecimal("price"));
        movie.setPicturePath(rs.getString("picture_path"));
        return movie;
    }
}
