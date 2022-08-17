package com.luv2code.springboot.thymeleafdemo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.luv2code.springboot.thymeleafdemo.dao.CustomerRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Customer;

@Transactional
@Rollback
@SpringBootTest(classes = ThymeleafdemoApplication.class)
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void testUserRepoIsNotNull() {
		Assertions.assertNotNull(customerRepository);
	}

	@Test
	void findUserById() {
		Customer customer = customerRepository.findById("Admin").get();
		Assertions.assertNotNull(customer);
		Assertions.assertEquals("Admin", customer.getFirstName());
	}

	@Test
	void testIfFindAllIsNotNull() {
		Assertions.assertNotNull(customerRepository.findAll());
	}
}
