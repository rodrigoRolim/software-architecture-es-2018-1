package com.mycompany.mavenproject1.database;

import com.mycompany.mavenproject1.data.Customer;
import java.util.HashSet;
import java.util.Set;

public class CustomerDatabase {
    
    private Set<Customer> customerDB;
    
    public void create(Customer c) throws Exception {
        if (customerDB == null)
            customerDB = new HashSet<>();
        
        if (customerDB.add(c) == false)
            throw new Exception("Customer already exists");
    }
    
   public Set<Customer> list() {
       return customerDB;
   }
    
}
