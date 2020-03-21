package org.wcci.apimastery;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {
    Optional<Attraction> findByName(String name);

    Optional<Attraction> findByCityName(String cityName);
}
