package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.data.Country;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountryDAOTest {

    private CountryDAO dao = new CountryDAO();

    public Country createEntity() {
        Country c = new Country();
        c.setName("Brazil");
        c.setAcronym("BR");
        c.setDigits(3);

        return c;
    }

    public void persistEntity() {
        Country c = createEntity();

        try {
            dao.create(c);

        } catch (Exception ex) {
            Logger.getLogger(CountryDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void create() {

        persistEntity();

        Assert.assertEquals("Brazil", dao.readByName("Brazil").getName());
    }

    @Test
    public void read() {
        persistEntity();

        Assert.assertTrue(dao.readAll().size() == 1);
        Assert.assertEquals(dao.readByName("Brazil").getAcronym(), "BR");
        Assert.assertEquals(dao.readByAcronym("BR").getName(), "Brazil");
    }

    @Test
    public void update() {
        persistEntity();

        Country c = createEntity();
        c.setDigits(8);

        dao.update(c, "Brazil");

        Assert.assertTrue(dao.readByName("Brazil").getDigits() == 8);
    }

    @Test
    public void delete() {
        persistEntity();

        dao.delete("Brazil");

         Assert.assertTrue(dao.readAll().size() == 0);
    }
}
