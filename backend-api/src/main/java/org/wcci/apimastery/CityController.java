package org.wcci.apimastery;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CityController {
    private CountryStorage countryStorage;
    private CityStorage cityStorage;
    private AttractionStorage attractionStorage;

    public CityController(CountryStorage countryStorage, CityStorage cityStorage, AttractionStorage attractionStorage) {
        this.countryStorage = countryStorage;
        this.cityStorage = cityStorage;
        this.attractionStorage = attractionStorage;
    }

    @GetMapping("/cities/{id}/")
    public City retrieveSingleCity(@PathVariable Long id) {
        return cityStorage.findById(id).get();
    }

    @GetMapping("/cities/{name}/")
    public City retrieveCityByName(@PathVariable String name) {
        return cityStorage.findByName(name).get();
    }

    @GetMapping("/cities/")
    public Collection<City> retrieveAllCities(){
        return cityStorage.findAllCities();
    }

    @DeleteMapping("/cities/{id}/")
    public void deleteCity(@PathVariable Long id) {
        City cityToRemove = cityStorage.findById(id).get();

        for (Attraction attractionToRemove : cityToRemove.getAttractions()) {
            attractionStorage.delete(attractionToRemove);
        }
        cityStorage.deleteById(id);
    }

    @PostMapping("/cities/")
    public City createCity(@RequestBody City cityToAdd){
        return cityStorage.store(cityToAdd);
    }

    @PatchMapping("/cities/{id}/attractions")
    public City updateCityAttractions(@PathVariable Long id, @RequestBody Attraction requestBodyAttraction){
        City cityToPatch = cityStorage.findById(id).get();
        Attraction attractionToAdd = new Attraction(cityToPatch, requestBodyAttraction.getName());
        attractionStorage.store(attractionToAdd);
        return cityStorage.store(cityToPatch);
    }
}
