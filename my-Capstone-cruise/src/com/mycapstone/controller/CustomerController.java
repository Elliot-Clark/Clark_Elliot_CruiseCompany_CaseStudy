package com.mycapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycapstone.entity.Cruises;
import com.mycapstone.entity.Customer;
import com.mycapstone.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
	// need to inject our customer service
	@Autowired
	private CustomerService customerService;

	public String currentUser = "";

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

	@GetMapping("/login")
	public String login(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);

		return "login";
	}

	@PostMapping("/validateCustomer")
	public String validateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		if (customerService.validateCustomer(theCustomer) != null) {
			currentUser = theCustomer.getEmail();
			return "redirect:/display";
		} else {
			return "redirect:/login";
		}
	}

	@GetMapping("/register")
	public String register(Model theModel) {

		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		System.out.println("Register");
		return "register";
	}

	@GetMapping("/addCruise")
	public String addCruise(@RequestParam("tempCruiseId") int theId) {
		customerService.addCruiseForCustomer(theId, currentUser);
		return "redirect:/display";
	}

	@GetMapping("/removeCruise")
	public String removeCruise(@RequestParam("customerSelectedCruisesId") int theId) {
		System.out.println("Removing a cruise");

		customerService.removeCruiseForCustomer(theId, currentUser);

		return "redirect:/display";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		System.out.println("Saving customer");
		customerService.saveCustomer(theCustomer);
		currentUser = theCustomer.getEmail();

		return "redirect:/display";
	}

	@GetMapping("/display")
	public String display(Model theModel) {

		// get customers from the service
		List<Cruises> theCruises = customerService.getCruises();

		// add the customers to the model
		theModel.addAttribute("cruises", theCruises);
		theModel.addAttribute("username", currentUser);

		// get the customer cruises from the service
		List<Cruises> theCustomerCruises = customerService.getCustomerCruises(currentUser);

		theModel.addAttribute("customerCruises", theCustomerCruises);

		return "display";
	}

}
