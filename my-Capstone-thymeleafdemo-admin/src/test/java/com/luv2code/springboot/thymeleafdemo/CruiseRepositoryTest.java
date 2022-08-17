package com.luv2code.springboot.thymeleafdemo;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.luv2code.springboot.thymeleafdemo.dao.CruiseRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Cruises;

@Transactional
@Rollback
@SpringBootTest(classes = ThymeleafdemoApplication.class)
public class CruiseRepositoryTest {

	@Autowired
	CruiseRepository cruiseRepository;

	@Test
	void testUserRepoIsNotNull() {
		Assertions.assertNotNull(cruiseRepository);
	}

	@Test
	void findUserById() {
		Cruises cruise = cruiseRepository.findById(1).get();
		Assertions.assertNotNull(cruise);
		Assertions.assertEquals(1, cruise.getId());
	}

	@Test
	void testIfFindAllIsNotNull() {
		Assertions.assertNotNull(cruiseRepository.findAll());
	}
}
