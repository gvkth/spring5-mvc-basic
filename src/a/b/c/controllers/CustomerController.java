package a.b.c.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import a.b.c.dao.CustomerDAO;
import a.b.c.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		//add the customers to the model
		
		return "list-customers";
	}
}
