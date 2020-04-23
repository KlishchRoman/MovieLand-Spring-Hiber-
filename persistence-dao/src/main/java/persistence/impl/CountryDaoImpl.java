package persistence.impl;

import domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import persistence.dao.CountryDao;
import persistence.mapper.CountryMapper;

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
        List<Country> countries = jdbcTemplate.query(queryFindAllCountries, countryMapper);
        return countries;
    }

    @Override
    public Country findCountryByCountryId(int country_id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("country_id", country_id);
        Country country = namedParameterJdbcTemplate.queryForObject(findCountryByCountryId, namedParameters, countryMapper);
        return country;
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
