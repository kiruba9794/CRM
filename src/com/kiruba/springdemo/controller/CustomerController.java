package com.kiruba.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiruba.springdemo.dao.CustomerDAO;
import com.kiruba.springdemo.entity.Customer;
import com.kiruba.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//injecting the customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer>theCustomers=customerService.getCustomers();
		
		model.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer thecustomer=new Customer();
		model.addAttribute("customer",thecustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,Model model) {
		
		Customer customer= customerService.getCustomer(theId);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
		
		
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName")String searchName,Model model) {
		
		
		List<Customer> theCustomers = customerService.searchCustomers(searchName);
        
        // add the customers to the model
        model.addAttribute("customers", theCustomers);
        return "list-customers";
		
		
	}
	
	
	
}
