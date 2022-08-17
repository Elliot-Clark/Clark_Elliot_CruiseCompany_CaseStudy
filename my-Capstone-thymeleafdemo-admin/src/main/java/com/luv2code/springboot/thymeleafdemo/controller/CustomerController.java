package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Cruises;
import com.luv2code.springboot.thymeleafdemo.entity.Customer;
import com.luv2code.springboot.thymeleafdemo.service.CruiseService;
import com.luv2code.springboot.thymeleafdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	private CruiseService cruiseService;

	public CustomerController(CustomerService theCustomerService, CruiseService theCruiseService) {
		customerService = theCustomerService;
		cruiseService = theCruiseService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from db
		List<Customer> theCustomers = customerService.findAll();
		// add to the spring model
		theModel.addAttribute("customers", theCustomers);

		// get cruises from db
		List<Cruises> theCruises = cruiseService.findAll();
		// add to the spring model
		theModel.addAttribute("cruises", theCruises);

		return "customers/list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		System.out.println("Showing form for add");
		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customers/customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") String theId, Model theModel) {

		// get the customer from the service
		Customer theCustomer = customerService.findById(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		System.out.println(theModel);

		// send over to our form
		return "customers/customer-form";
	}

	@GetMapping("/showFormForCruiseAdd")
	public String showFormForCruiseAdd(Model theModel) {

		System.out.println("Showing form for cruise add");

		Cruises theCruise = new Cruises();

		theModel.addAttribute("cruises", theCruise);

		return "customers/cruise-form";
	}

	@GetMapping("/showFormForCruiseUpdate")
	public String showFormForCruiseUpdate(@RequestParam("cruiseId") int theId, Model theModel) {

		System.out.println("Showing form for cruise update");
		// create model attribute to bind form data
		Cruises theCruise = cruiseService.findById(theId);

		theModel.addAttribute("cruises", theCruise);
		System.out.println(theModel);

		return "customers/cruise-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		System.out.println("Saving updates to customer");
		System.out.println(theCustomer);
		// save the customer
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}

	@PostMapping("/saveCruise")
	public String saveCruise(@ModelAttribute("cruise") Cruises theCruise) {

		System.out.println("Saving Cruises");
		System.out.println(theCruise.toString());
		// save the customer
		cruiseService.save(theCruise);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}

	@GetMapping("/delete")
	public String deleteById(@RequestParam("customerId") String theId) {

		// delete the customer
		customerService.deleteById(theId);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}

	@GetMapping("/deleteCruise")
	public String deleteCruiseById(@RequestParam("cruiseId") int theId) {

		System.out.println("Deleting Cruise");
		// delete the customer
		cruiseService.deleteById(theId);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}

}
