package com.mycapstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycapstone.dao.CruiseDAO;
import com.mycapstone.dao.CustomerDAO;
import com.mycapstone.entity.Cruises;
import com.mycapstone.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CruiseDAO cruiseDAO;

	@Override
	@Transactional
	public List<Cruises> getCruises() {
		return cruiseDAO.getCruises();
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(String theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public Customer validateCustomer(Customer theCustomer) {

		return customerDAO.validateCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(String theId) {

		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public void addCruiseForCustomer(int theId, String currentUser) {
		customerDAO.addCruiseForCustomer(theId, currentUser);

	}

	@Override
	@Transactional
	public List<Cruises> getCustomerCruises(String currentUser) {
		return customerDAO.getCustomerCruises(currentUser);
	}

	@Override
	@Transactional
	public void removeCruiseForCustomer(int theId, String currentUser) {
		customerDAO.removeCruiseForCustomer(theId, currentUser);

	}

}
