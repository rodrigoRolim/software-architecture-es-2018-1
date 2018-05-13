package com.mycompany.mavenproject1.ui.control;

import com.mycompany.mavenproject1.business.CustomerBusiness;
import com.mycompany.mavenproject1.data.Customer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/countryController")
public class CustomerController extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Customer newCustomer = new Customer();
        
        CustomerBusiness CustomerBusiness = new CustomerBusiness();
        
        try {
            CustomerBusiness.create(newCustomer);
            req.getSession().setAttribute("countryList", CustomerBusiness.readAll());
            
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}