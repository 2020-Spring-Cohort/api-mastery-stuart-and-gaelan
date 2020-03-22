package org.wcci.apimastery;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    Optional<City> findByName(String name);

    Optional<City> findById(Long id);

    Optional<City> findByCountryName(String countryName);
}
