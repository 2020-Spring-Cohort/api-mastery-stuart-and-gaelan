package org.wcci.apimastery;

import java.util.Collection;
import java.util.Optional;

public interface AttractionStorage {

    Optional<Attraction> findById(Long id);

    Optional<Attraction> findByName(String name);

    Optional<Attraction> findByCity(String cityName);

    Attraction store(Attraction attractionToStore);

    void delete(Attraction attractionToRemove);

    Collection<Attraction> findAll();

    void deleteById(Long id);
}
