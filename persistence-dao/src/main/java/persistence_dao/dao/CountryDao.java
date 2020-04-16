package persistence_dao.dao;

import domain.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDao {
    List<Country> findAllCountries();
    List<Country> findCountryByCountryId(int country_id);
}
