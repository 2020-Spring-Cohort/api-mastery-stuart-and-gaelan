package org.wcci.apimastery;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CountryStorageJpa implements CountryStorage {

    private CountryRepository countryRepository;

    public CountryStorageJpa(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public Collection<Country> findAllCountries() {
        return (Collection<Country>) countryRepository.findAll();
    }

    @Override
    public void store(Country country) {
        countryRepository.save(country);
    }

    @Override
    public Optional<Country> findCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> findCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {

    }
}
