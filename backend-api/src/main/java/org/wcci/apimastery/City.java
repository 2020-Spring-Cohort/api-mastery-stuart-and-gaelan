package org.wcci.apimastery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class City {
    public String name;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Country country;

    @OneToMany(mappedBy = "city")
    @JsonBackReference
    private Collection<Attraction> attractions;

    public City(String name, Country country){
        this.name = name;
        this.country = country;

    }

    public City(){}

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }
    public Country getCountry(){
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        return country != null ? country.equals(city.country) : city.country == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public Collection<Attraction> getAttractions() {
        return attractions;
    }
}
