package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private CountryStorage countryStorage;
    @Autowired
    private CityStorage cityStorage;
    @Autowired
    private AttractionStorage attractionStorage;


    @Override
    public void run(String... args) throws Exception {
        Country france = new Country("France");
        countryStorage.store(france);
        Country italy = new Country("Italy");
        countryStorage.store(italy);

        City paris = new City("Paris", france);
        cityStorage.store(paris);
        City rome = new City("Rome", italy);
        cityStorage.store(rome);

        Attraction eiffel = new Attraction(paris, "Eiffel Tower" );
        attractionStorage.store(eiffel);
        Attraction vatican = new Attraction(rome, "Vatican");
        attractionStorage.store(vatican);


    }
}
