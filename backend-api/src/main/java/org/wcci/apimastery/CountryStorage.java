package org.wcci.apimastery;

import java.util.Collection;
import java.util.Optional;

public interface CountryStorage {
    Collection<Country> findAllCountries();

    void store(Country country);

    Optional<Country> findCountryById(Long id);

    Optional<Country> findCountryByName(String name);
}
