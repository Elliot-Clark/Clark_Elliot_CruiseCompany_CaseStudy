package com.mycapstone.service;

import java.util.List;

import com.mycapstone.entity.Cruises;
import com.mycapstone.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(String theId);

	public Customer validateCustomer(Customer theCustomer);

	public void deleteCustomer(String theId);

	public void addCruiseForCustomer(int theId, String currentUser);

	public List<Cruises> getCruises();

	public List<Cruises> getCustomerCruises(String currentUser);

	public void removeCruiseForCustomer(int theId, String currentUser);

}