package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Country;
import com.rk.movieland.persistence.dao.CountryDao;
import com.rk.movieland.persistence.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {
    private static final CountryMapper countryMapper = new CountryMapper();

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${queryFindAllCountries}")
    private String queryFindAllCountries;

    @Value("${queryFindCountryByCountryId}")
    private String findCountryByCountryId;


    @Override
    public List<Country> findAllCountries() {
        return jdbcTemplate.query(queryFindAllCountries, countryMapper);
    }

    @Override
    public Country findCountryByCountryId(int country_id) {
        try {
            SqlParameterSource namedParameters = new MapSqlParameterSource("country_id", country_id);
            return namedParameterJdbcTemplate.queryForObject(findCountryByCountryId, namedParameters, countryMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void save(Country country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Country country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Country country) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}
