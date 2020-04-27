package com.rk.movieland.persistence.dao.impl;

import com.rk.movieland.domain.Country;
import com.rk.movieland.persistence.dao.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationTest.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class CountryDaoImplTest {

    @Autowired
    CountryDaoImpl countryDao;

    @Test
    void shouldReturnListAllCountries() {
        List<Country> countries = countryDao.findAllCountries();
        assertEquals(countries.size(), 7);
    }

    @Test
    void shouldFindCountry_CountryId() {
        Country countryFromDb = countryDao.findCountryByCountryId(1);
        Country expectedCountry = new Country(1, "США");
        assertEquals(expectedCountry, countryFromDb);
    }

    @Test
    void shouldReturnNull_IncorrectId() {
        Country countryFromDb = countryDao.findCountryByCountryId(15);
        assertNull(countryFromDb);
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