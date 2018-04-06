package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.data.Country;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountryDAOTest {

    private CountryDAO dao = new CountryDAO();

    @BeforeClass
    private static Country createEntity() {
        Country c = new Country();
        c.setName("Brazil");
        c.setAcronym("BR");
        c.setDigits(3);

        return c;
    }

    private void persistEntity() {
        Country c = createEntity();

        try {
            dao.create(c);

        } catch (Exception ex) {
            Logger.getLogger(CountryDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    void create() {

        persistEntity();

        Assert.assertEquals("Brazil", dao.readByName("Brazil"));
    }

    @Test
    void read() {
        persistEntity();

        dao.readAll();
        dao.readByName("Brazil");
        dao.readByAcronym("BR");

        // Assertion
    }

    @Test
    void update() {
        persistEntity();

        Country c = createEntity();
        c.setDigits(8);

        dao.update(c, "Brazil");

        // Assertion
    }

    @Test
    void delete() {
        persistEntity();

        dao.delete("Brazil");

        // Assertion
    }
}
