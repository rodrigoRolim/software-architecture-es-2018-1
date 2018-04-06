package com.mycompany.mavenproject1.dao;

import java.util.Set;

import com.mycompany.mavenproject1.data.Customer;
import java.util.HashSet;

public class CustomerDAO {

    private Set<Customer> customerDB;

    public CustomerDAO() {
        super();

        this.customerDB = new HashSet<>();
    }

    public void create(Customer customer) throws Exception {
        if (customerDB.add(customer) == false)
            throw new Exception("Customer already exists");
    }

    public Customer readByName(String name) {
        return customerDB.
                        stream().
                        filter(
                            customer -> customer.getName().
                                                equalsIgnoreCase(name)).
                        findAny().
                        get();
    }

    public Set<Customer> readAll() {
        return customerDB;
    }

    public void update (Customer newCustomer, String name) throws Exception {
        Customer currentCustomer = this.readByName(name);

        if (currentCustomer != null) {
            currentCustomer.setName(newCustomer.getName());
            currentCustomer.setAge(newCustomer.getAge());
            currentCustomer.setCountry(newCustomer.getCountry());
            currentCustomer.setPhone(newCustomer.getPhone());
            currentCustomer.setCreditLimit(newCustomer.getCreditLimit());
        }
    }

    public void delete (String name) {
        Customer currentCustomer = this.readByName(name);

        if (currentCustomer != null) 
            customerDB.removeIf(customer -> customer.equals(currentCustomer));
    }

}