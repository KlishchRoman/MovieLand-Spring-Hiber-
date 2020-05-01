package com.rk.movieland.persistence.mapper;

import com.rk.movieland.domain.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country(resultSet.getInt("country_id"), resultSet.getString("country_name"));
        return country;
    }
}
