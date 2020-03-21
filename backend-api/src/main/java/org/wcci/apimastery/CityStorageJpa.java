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
    public Optional<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public Optional<City> findByCityName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public Optional<City> findCityByCountry(String countryName) {
        return cityRepository.findByCountryName(countryName);
    }

    @Override
    public void store(City cityToStore) {
        cityRepository.save(cityToStore);
    }

    @Override
    public void delete(City cityToRemove) {

    }
}
