package org.wcci.apimastery;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttractionStorageJpa implements AttractionStorage{

    private AttractionRepository attractionRepository;

    public AttractionStorageJpa(AttractionRepository attractionRepository){
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Optional<Attraction> findById(Long id) {
        return attractionRepository.findById(id);
    }

    @Override
    public Optional<Attraction> findByName(String name) {
        return attractionRepository.findByName(name);
    }

    @Override
    public Optional<Attraction> findByCity(String cityName) {
        return attractionRepository.findByCityName(cityName);
    }

    @Override
    public void store(Attraction attractionToStore) {
        attractionRepository.save(attractionToStore);
    }

    @Override
    public void delete(Attraction attractionToRemove) {
        attractionRepository.delete(attractionToRemove);
    }
}
