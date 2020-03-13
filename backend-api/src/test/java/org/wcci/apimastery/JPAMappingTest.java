package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAMappingTest {
    @Autowired
    private CountryRepository countryRepo;
    @Autowired
    private CityRepository cityRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void citiesShouldHaveACountry(){
        Country testCountry = new Country("testCountry");
        countryRepo.save(testCountry);

        City testCity1 = new City("testCity1", testCountry);
        cityRepo.save(testCity1);
        City testCity2 = new City("testCity2", testCountry);
        cityRepo.save(testCity2);

        entityManager.flush();
        entityManager.clear();

        Country retrievedCountry = countryRepo.findById(testCountry.getId()).get();
        City retrievedCity1 = cityRepo.findById(testCity1.getId()).get();
        City retrievedCity2 = cityRepo.findById(testCity2.getId()).get();
        assertThat(retrievedCountry.getCities()).contains(retrievedCity1, retrievedCity2);


    }
}
