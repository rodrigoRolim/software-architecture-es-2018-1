package com.mycompany.mavenproject1.business;

import java.util.Set;

import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;

public class FacadeCountryCustomer {
  private final CountryBusiness countryBusiness;
  private final CustomerBusiness customerBusiness;

  public FacadeCountryCustomer() {
    this.countryBusiness = new CountryBusiness();
    this.customerBusiness = new CustomerBusiness();
  }

  public void create(Country country) throws Exception {
    countryBusiness.create(country);
  }

  public void create(Customer customer) throws Exception {
    customerBusiness.create(customer);
  }

  public String readAllCustomersToString() {
    return customerBusiness.readAll().toString();
  }

  public String readAllCountryToString() {
    return countryBusiness.readAll().toString();
  }
  
  public Set<Customer> readAllCustomers() {
    return customerBusiness.readAll();
  }
  public Set<Country> readAllCountry() {
    return countryBusiness.readAll();
  }
  
}

