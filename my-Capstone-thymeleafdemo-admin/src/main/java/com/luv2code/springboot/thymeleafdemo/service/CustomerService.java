package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(String theId);

	public void save(Customer theCustomer);

	public void deleteById(String theId);

}
