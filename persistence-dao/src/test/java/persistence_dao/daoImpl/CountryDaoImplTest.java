package persistence_dao.daoImpl;

import domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import persistence_dao.ApplicationTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
class CountryDaoImplTest {

    @Autowired
    CountryDaoImpl countryDao;

    @Test
    void findAllCountries() {
        List<Country> countries = countryDao.findAllCountries();
        assertFalse(countries.isEmpty());
    }

    @Test
    void findCountryByCountryId() {
        Country countryFromDb = countryDao.findCountryByCountryId(1);
        Country country = new Country(1, "США");
        assertTrue(country.equals(countryFromDb));
    }

    @Test
    void save() {
        assertThrows(UnsupportedOperationException.class,
                () -> countryDao.save(new Country()),
                "Save not supported yet.");
    }

    @Test
    void update() {
        assertThrows(UnsupportedOperationException.class,
                () -> countryDao.update(new Country()),
                "Update not supported yet.");
    }

    @Test
    void delete() {
        assertThrows(UnsupportedOperationException.class,
                () -> countryDao.delete(new Country()),
                "Delete not supported yet.");
    }
}