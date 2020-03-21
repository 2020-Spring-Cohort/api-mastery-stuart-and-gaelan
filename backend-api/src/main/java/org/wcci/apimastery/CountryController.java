package org.wcci.apimastery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CountryController {
    private CountryRepository countryRepository;
    private CityRepository cityRepository;

    public CountryController(CountryRepository countryRepository, CityRepository cityRepository){
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/countries/")
    public Collection<Country> retrieveCountries(){
        return (Collection<Country>) countryRepository.findAll();
    }


}
