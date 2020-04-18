package persistence_dao.dao;

import domain.Country;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CountryDao {
    List<Country> findAllCountries();

    Country findCountryByCountryId(int country_id);

    void save(Country country);

    void update(Country country);

    void delete(Country country);
}
