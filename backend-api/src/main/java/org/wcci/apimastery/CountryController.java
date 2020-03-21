package org.wcci.apimastery;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CountryController {
    private CountryStorage countryStorage;
    private CountryRepository countryRepository;
    private CityStorage cityStorage;

    public CountryController(CountryStorage countryStorage, CountryRepository countryRepository, CityStorage cityStorage){
        this.countryStorage = countryStorage;
        this.countryRepository = countryRepository;
        this.cityStorage = cityStorage;
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
}
