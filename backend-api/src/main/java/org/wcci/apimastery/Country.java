package org.wcci.apimastery;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Country {
    private String name;
     @Id
     @GeneratedValue
     private Long id;

     @OneToMany(mappedBy= "country")
     @JsonBackReference
     private Collection<City> cities;

     public Country(String name){
         this.name = name;
     }

    public Country(){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Collection <City> getCities() {
         return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        return id != null ? id.equals(country.id) : country.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
