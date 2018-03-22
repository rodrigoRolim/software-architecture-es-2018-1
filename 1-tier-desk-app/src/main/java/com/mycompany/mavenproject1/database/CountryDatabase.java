package com.mycompany.mavenproject1.database;

import com.mycompany.mavenproject1.data.Country;
import java.util.HashSet;
import java.util.Set;

public class CountryDatabase {
    
    private Set<Country> countryDB;
    
    public void create(Country c) throws Exception {
        if (countryDB == null)
            countryDB = new HashSet<>();
        
        if (countryDB.add(c) == false)
            throw new Exception("Country already exists");
    }
    
   public Set<Country> list() {
       return countryDB;
   }
    
}
