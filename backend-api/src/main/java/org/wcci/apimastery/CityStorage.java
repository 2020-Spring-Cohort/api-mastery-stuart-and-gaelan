package org.wcci.apimastery;

import java.util.Collection;
import java.util.Optional;

public interface CityStorage {
    Collection<City> findAllCities();

    Optional<City> findCityById(Long id);

    Optional<City> findByCityName(String name);

    Optional<City> findCityByCountry(String countryName);

    void store(City cityToStore);

    void delete(City cityToRemove);
}
