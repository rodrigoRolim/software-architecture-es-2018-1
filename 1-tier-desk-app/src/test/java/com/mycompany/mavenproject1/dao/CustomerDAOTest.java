package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAOTest {

    private CustomerDAO dao = new CustomerDAO();

    // @BeforeClass
    private static Customer createEntity() {
        
        Country country = new Country();
        country.setAcronym("BR");
        country.setDigits(3);
        country.setName("Brazil");
        
        Customer c = new Customer();
        c.setAge(21);
        
        try {
            c.setCountry(country);
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        c.setCreditLimit(0);
        
        try {
            c.setName("Andrew");
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            c.setPhone("123");
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    private void persistEntity() {
        Customer c = createEntity();

        try {
            dao.create(c);

        } catch (Exception ex) {
            Logger.getLogger(CountryDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // @Test
    void create() {

        persistEntity();

        // Assertion
    }

    // @Test
    void read() {
        persistEntity();

        dao.readAll();
        dao.readByName("Andrew");

        // Assertion
    }

    // @Test
    void update() {
        persistEntity();

        Customer c = createEntity();
        c.setAge(56);

        try {
            dao.update(c, "Andrew");
            
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Assertion
    }

    // @Test
    void delete() {
        persistEntity();

        dao.delete("Andrew");

        // Assertion
    }
}
