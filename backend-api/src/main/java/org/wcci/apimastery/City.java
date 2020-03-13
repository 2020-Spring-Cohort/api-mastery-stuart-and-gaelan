package org.wcci.apimastery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {
    public String name;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Country country;

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
}
