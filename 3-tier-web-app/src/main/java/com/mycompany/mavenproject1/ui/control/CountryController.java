
package com.mycompany.mavenproject1.ui.control;

import com.mycompany.mavenproject1.business.CountryBusiness;
import com.mycompany.mavenproject1.data.Country;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/countryController")
public class CountryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Country newCountry = new Country(
                                        0, 
                                        req.getParameter("inputName"), 
                                        req.getParameter("inputAcronym"), 
                                        new Integer(req.getParameter("inputDigits"))
                                        );
        
        CountryBusiness business = new CountryBusiness();
        
        try {
            business.create(newCountry);
            req.getSession().setAttribute("countryList", business.readAll());
            
        } catch (Exception ex) {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
