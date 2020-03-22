package org.wcci.apimastery;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CountryController {
    private CountryStorage countryStorage;
    private CountryRepository countryRepository;
    private CityStorage cityStorage;
    private CityRepository cityRepository;

    public CountryController(CountryStorage countryStorage, CountryRepository countryRepository, CityStorage cityStorage, CityRepository cityRepository){
        this.countryStorage = countryStorage;
        this.countryRepository = countryRepository;
        this.cityStorage = cityStorage;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/countries/")
    public Collection<Country> retrieveCountries(){
        return countryStorage.findAllCountries();
    }

    @GetMapping("/countries/{id}/")
    public Country retrieveSingleCountry(@PathVariable Long id){
        return countryStorage.findCountryById(id).get();
    }

    @DeleteMapping("/countries/{id}/")
    public void deleteCountry(@PathVariable Long id){
        Country countryToRemove = countryStorage.findCountryById(id).get();

        for(City cityToRemove : countryToRemove.getCities()){
            cityStorage.delete(cityToRemove);
        }
        countryStorage.deleteById(id);
    }

    @PostMapping("/countries/")
    public Country createCountry(@RequestBody Country countryToAdd){
        return countryRepository.save(countryToAdd);
    }

    @PatchMapping("/countries/{id}/cities/")
    public Country updateCountryCities(@PathVariable Long id, @RequestBody City requestBodyCity){
        Country countryToPatch = countryRepository.findById(id).get();
        City cityToAdd = new City(requestBodyCity.getName(), countryToPatch);
        cityRepository.save(cityToAdd);
        return countryRepository.save(countryToPatch);
    }
}
