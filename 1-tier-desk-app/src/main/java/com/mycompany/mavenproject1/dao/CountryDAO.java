package com.mycompany.mavenproject1.dao;

import java.util.Set;

import com.mycompany.mavenproject1.data.Country;
import java.util.HashSet;

public class CountryDAO {

    private Set<Country> countryDB;

    public CountryDAO() {
        super();

        this.countryDB = new HashSet<>();
    }

    public void create(Country country) throws Exception {
        if (countryDB.add(country) == false)
            throw new Exception("Country already exists");
    }

    public Country readByAcronym(String acronym) {
        return countryDB.
                        stream().
                        filter(
                            country -> country.getAcronym().
                                                equalsIgnoreCase(acronym)).
                        findAny().
                        get();
    }

    public Country readByName(String name) {
        return countryDB.
                        stream().
                        filter(
                            country -> country.getName().
                                                equalsIgnoreCase(name)).
                        findAny().
                        get();
    }

    public Set<Country> readAll() {
        return countryDB;
    }

    public void update (Country newCountry, String name) {
        Country currentCountry = this.readByName(name);

        if (currentCountry != null) {
            currentCountry.setName(newCountry.getName());
            currentCountry.setAcronym(newCountry.getAcronym());
            currentCountry.setDigits(newCountry.getDigits());
        }
    }

    public void delete (String name) {
        Country currentCountry = this.readByName(name);

        if (currentCountry != null) 
            countryDB.removeIf(country -> country.equals(currentCountry));
    }

}