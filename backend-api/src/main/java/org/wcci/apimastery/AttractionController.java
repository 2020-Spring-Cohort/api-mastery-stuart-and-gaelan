package org.wcci.apimastery;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AttractionController {

    private AttractionStorage attractionStorage;

    public AttractionController(AttractionStorage attractionStorage) {
        this.attractionStorage = attractionStorage;
    }

    @GetMapping("/attractions/")
    public Collection<Attraction> retrieveAttractions(){
        return attractionStorage.findAll();
    }

    @GetMapping("/attractions/{id}/")
    public java.util.Optional<Attraction> retrieveAttractionById(@PathVariable Long id){
        return attractionStorage.findById(id);
    }

    @DeleteMapping("/attractions/{id}/")
    public void deleteAttractions(@PathVariable Long id){
        attractionStorage.deleteById(id);
    }

    @PostMapping("/attractions/")
    public Attraction createAttraction(@RequestBody Attraction attractionToAdd){
        return attractionStorage.store(attractionToAdd);
    }

//    @PatchMapping("/attractions/{id}/")
//    public Attraction updateAttraction(@PathVariable Long id){
//        do we need this?  How would we patch an attraction?
//    }
}
