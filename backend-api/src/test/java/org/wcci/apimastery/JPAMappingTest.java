package org.wcci.apimastery;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
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
    @Autowired
    private AttractionRepository attractionRepo;


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

    @Test
    public void attractionsShouldHaveACity(){
        Country testNation = new Country("Test Germany");
        countryRepo.save(testNation);

        City testCity1 = new City("Test1", testNation);
        cityRepo.save(testCity1);
        Attraction testAttraction = new Attraction(testNation, testCity1, "FunZone");
        attractionRepo.save(testAttraction);
        Attraction otherTestAttraction = new Attraction(testNation, testCity1, "BadZone");
        attractionRepo.save(otherTestAttraction);

        entityManager.flush();
        entityManager.clear();

        City retrievedCity = cityRepo.findById(testCity1.getId()).get();
        Attraction retrievedAttraction1 = attractionRepo.findById(testAttraction.getId()).get();
        Attraction retrievedAttraction2 = attractionRepo.findById(otherTestAttraction.getId()).get();
        assertThat(retrievedCity.getAttractions()).contains(retrievedAttraction1, retrievedAttraction2);
    }
}
