package org.wcci.apimastery;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CityStorageJpa implements CityStorage {
    private CityRepository cityRepository;

    public CityStorageJpa(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public Collection<City> findAllCities() {
        return (Collection<City>) cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<City> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<City> findByCountry(String countryName) {
        return Optional.empty();
    }

    @Override
    public City store(City cityToStore) {
        cityRepository.save(cityToStore);
        return cityToStore;
    }

    @Override
    public void deleteById(Long id) {

    }
}
