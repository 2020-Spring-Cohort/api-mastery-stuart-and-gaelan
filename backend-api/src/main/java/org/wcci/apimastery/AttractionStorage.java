package org.wcci.apimastery;

import java.util.Optional;

public interface AttractionStorage {

    Optional<Attraction> findById(Long id);

    Optional<Attraction> findByName(String name);

    Optional<Attraction> findByCity(String cityName);

    void store(Attraction attractionToStore);
}
