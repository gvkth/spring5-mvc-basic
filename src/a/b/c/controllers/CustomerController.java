package a.b.c.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import a.b.c.dao.CustomerDAO;
import a.b.c.entity.Customer;
import a.b.c.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		//add the customers to the model
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
		
	}
	
}
