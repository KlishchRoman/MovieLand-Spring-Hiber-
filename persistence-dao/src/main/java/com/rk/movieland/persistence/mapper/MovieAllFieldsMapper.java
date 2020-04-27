package com.rk.movieland.persistence.mapper;

import com.rk.movieland.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieAllFieldsMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movieFromBD = new Movie();
        movieFromBD.setMovieId(rs.getInt("movie_id"));
        movieFromBD.setNameRussian(rs.getString("name_russian"));
        movieFromBD.setNameNative(rs.getString("name_native"));
        movieFromBD.setYearOfRelease(rs.getInt("year_of_release"));
        movieFromBD.setRating(rs.getFloat("rating"));
        movieFromBD.setPrice(rs.getBigDecimal("price"));
        movieFromBD.setPicturePath(rs.getString("picture_path"));
        return movieFromBD;
    }
}
