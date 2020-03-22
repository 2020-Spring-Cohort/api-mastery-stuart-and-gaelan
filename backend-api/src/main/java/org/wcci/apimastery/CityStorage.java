package org.wcci.apimastery;

import java.util.Collection;
import java.util.Optional;

public interface CityStorage {
    Collection<City> findAllCities();

    Optional<City> findById(Long id);

    Optional<City> findByName(String name);

    Optional<City> findByCountry(String countryName);

    City store(City cityToStore);

    void deleteById(Long id);
    
}
